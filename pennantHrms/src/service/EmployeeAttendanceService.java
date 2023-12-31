package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import DAO.EmployeeAttendanceDAOImpl;
import DAO_Interfaces.EmployeeAttendanceDAO;
import DAO_Interfaces.EmployeeLeaveRequestDAO;
import models.AttendanceEvent;
import models.EmployeeAttendance;
import models.EmployeeAttendanceId;
import models.EmployeeLeaveRequest;
import models.EmployeeRequestResult;
import service_interfaces.EmployeeAttendanceServiceInterface;
import service_interfaces.EmployeeLeaveServiceInterface;

@Service
public class EmployeeAttendanceService implements EmployeeAttendanceServiceInterface {

	private static Logger logger = LoggerFactory.getLogger(EmployeeAttendanceDAOImpl.class);

	private EmployeeAttendanceDAO employeeAttendanceDAO;

	private EmployeeAttendance attendance;
	private EmployeeAttendanceId attendanceId;
	private EmployeeLeaveRequestDAO leaveRequestDAO;

	@Autowired
	public EmployeeAttendanceService(EmployeeAttendanceDAO employeeAttendanceDAO, EmployeeAttendance attendance,
			EmployeeAttendanceId attendanceId,EmployeeLeaveRequestDAO leaveRequestDAO) {
		this.employeeAttendanceDAO = employeeAttendanceDAO;
		this.attendance = attendance;
		this.attendanceId = attendanceId;
		this.leaveRequestDAO = leaveRequestDAO;
	}

	@Transactional
	@Override
	public void insertEmployeeAttendance(EmployeeAttendance attendance) {
		employeeAttendanceDAO.save(attendance);
		logger.info("Employee attendance inserted successfully.");

	}

	@Override
	public List<AttendanceEvent> getYesterdayPunchData(int employeeId) {

		try {
			// Retrieve punch-in and punch-out data from the DAO
			List<Object[]> results = employeeAttendanceDAO.getYesterdayPunchInAndPunchOut(employeeId);

			// Formatting the data required for the graphs
			List<AttendanceEvent> formattedEvents = new ArrayList<>();
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh:mm a");
			for (Object[] row : results) {
				LocalDateTime punchIn = (LocalDateTime) row[0];
				LocalDateTime punchOut = (LocalDateTime) row[1];

				// Format punch-in time
				String formattedPunchIn = punchIn.format(outputFormatter);
				// Format punch-out time
				String formattedPunchOut = punchOut.format(outputFormatter);
				// Create AttendanceEvent object for punch-in event
				AttendanceEvent attendanceEvent = new AttendanceEvent();
				attendanceEvent.setTime(formattedPunchIn);
				attendanceEvent.setEvent("Punch In");
				formattedEvents.add(attendanceEvent);
				// Create AttendanceEvent object for punch-out event
				attendanceEvent = new AttendanceEvent();
				attendanceEvent.setTime(formattedPunchOut);
				attendanceEvent.setEvent("Punch Out");
				formattedEvents.add(attendanceEvent);
			}

			logger.info("Employee Yesterday Punch data is successfully loaded into model");

			// Return the list of formatted events
			return formattedEvents;
		} catch (Exception e) {
			logger.error("Failed to get yesterday's punch data for EmployeeId", e);
			return Collections.emptyList();
		}
	}
	
	
	// get total working days
	private int getTotalWorkingDays(int totalnoofdays,int year, int month) {
		int totalWorkingDays = 0;
		for (int day = 1; day <= totalnoofdays; day++) {
		    LocalDate date = LocalDate.of(year, month, day);
		    DayOfWeek dayOfWeek = date.getDayOfWeek();
		    if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
		        totalWorkingDays++;
		    }
		}
		
		return totalWorkingDays;	
	}

	@Override
	public EmployeeRequestResult calculateAttendance(int id, int year, int month) {

		try {

			logger.info("calculating the Attendance");

			List<Object[]> punchData = employeeAttendanceDAO.getPunchInAndPunchOutDataForYearAndMonthAndEmployee(id,
					year, month);
			// Retrieves the punch in and punch out data for the specified year, month, and employee ID from the DAO

			if (punchData == null || punchData.isEmpty()) {

				logger.warn("No attendance data found for year,month,employee ID");
			}

			YearMonth yearMonthObject = YearMonth.of(year, month);
			
			// total no of days in a month
			int totalnoofdays = yearMonthObject.lengthOfMonth();
			
			int totalworkingdays  = getTotalWorkingDays(totalnoofdays, year, month);
			int daysWithMinimumHours = 0;
			Map<LocalDateTime, Duration> workingHoursPerDay = new HashMap<>();

			// Iterate over the punch-in and punch-out data
			for (Object[] punches : punchData) {
				LocalDateTime punchIn = (LocalDateTime) punches[0];
				LocalDateTime punchOut = (LocalDateTime) punches[1];

				// Skip data with missing punch-in or punch-out
				if (punchIn == null || punchOut == null) {
					continue;
				}
				// Calculate the duration between punch-in and punch-out
				Duration duration = Duration.between(punchIn, punchOut);
				LocalDateTime dateOnly = punchIn.toLocalDate().atStartOfDay();
				// Update the working hours for the specific day
				if (workingHoursPerDay.containsKey(dateOnly)) {
					Duration totalDuration = workingHoursPerDay.get(dateOnly).plus(duration);
					workingHoursPerDay.put(dateOnly, totalDuration);
				} else {
					workingHoursPerDay.put(dateOnly, duration);
				}
			}
			// Count the number of days with minimum working hours (8 hours)
			for (Duration duration : workingHoursPerDay.values()) {
				long hours = duration.toHours();

				if (hours >= 8) {
					daysWithMinimumHours++;
				}
			}

			int totalDays = totalworkingdays;
			LocalDate current = LocalDate.now();
			
			// if attendance requested for current month
			if (current.getYear() == year && current.getMonthValue() == month) {
				totalDays = getTotalWorkingDays(current.getDayOfMonth(), year, month);
			}
			
			// get no of leaves taken in a month
			int noofleaves = 0;
			List<EmployeeLeaveRequest> leavesdata = leaveRequestDAO.getApprovedLeaveRequestsOfMonth(id, year, month);
			for(EmployeeLeaveRequest leave : leavesdata) {
				 noofleaves+=ChronoUnit.DAYS.between(leave.getApprovedLeaveStartDate(), leave.getApprovedLeaveEndDate()) + 1;
			}
			
			
			daysWithMinimumHours+=noofleaves;
			
			// Calculate the attendance percentage
			double attendancePercentage = (double) daysWithMinimumHours / totalDays * 100;

			if (Double.isNaN(attendancePercentage)) {
				attendancePercentage = 0.0;
			}

			EmployeeRequestResult response = new EmployeeRequestResult();

			response.setDayswithminhrs(daysWithMinimumHours);
			response.setPercentage(attendancePercentage);
			response.setTotaldays(totalDays);
			response.setAttendanceData(workingHoursPerDay);

			for (Map.Entry<LocalDateTime, Duration> map : workingHoursPerDay.entrySet())
				System.out.println("key " + map.getKey() + "  value " + map.getValue());

			logger.info("successfully calculated the attendance");

			return response;

		} catch (Exception e) {
			logger.error("Failed to calculate the Attendance ", e);
			return null;
		}

	}

	@Override
	public LocalDateTime convertToDateTime(Cell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			// Assuming the cell contains a date/time value
			return cell.getLocalDateTimeCellValue();
		} else {
			// Handle other cell types or formats as needed
			return null;
		}
	}

	@Override
	public List<Integer> getYears(Date joinDate) {

		logger.info("Generating the list of years till now from the join date of an employee");

		// Convert the joinDate to a LocalDate object
		LocalDate join = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(joinDate));
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Create a list to store the years
		List<Integer> yearList = new ArrayList<>();
		// Get the year of the join date
		int joinYear = join.getYear();
		// Get the year of the current date
		int currentYear = currentDate.getYear();
		// Iterate from the join year to the current year (inclusive)
		while (joinYear <= currentYear) {
			// Add the current year to the yearList
			yearList.add(joinYear);
			// Move to the next year
			joinYear++;
		}

		logger.info("successfully generated the Years List");

		// Return the list of years
		return yearList;

	}

	@Override
	public List<Long> getAvgPunchInAndOut(int id) {

		try {

			logger.info("calculating the average Punch Data");

			int i;
			long punchin = 0, punchout = 0;
			// Retrieve the punch-in and punch-out data for the current year and month
			List<Object[]> punchData = employeeAttendanceDAO.getPunchInAndPunchOutDataForYearAndMonthAndEmployee(id,
					LocalDate.now().getYear(), LocalDate.now().getMonthValue());
			List<Long> result = new ArrayList<>();

			if (punchData.size() > 0) {

				List<LocalDateTime> noofDays = new ArrayList<>();
				LocalDateTime dateOnly = null;

				// Iterate over the punch data
				for (i = 0; i < punchData.size() - 1; i++) {

					LocalDateTime pInOfCurrent = (LocalDateTime) punchData.get(i)[0];
					LocalDateTime pOutOfCurrent = (LocalDateTime) punchData.get(i)[1];
					LocalDateTime pInOfNext = (LocalDateTime) punchData.get(i + 1)[0];

					if (pInOfCurrent != null && pOutOfCurrent != null) {
						// Calculate the total punch-in time in minutes
						punchin += Duration.between(pInOfCurrent, pOutOfCurrent).toMinutes();

					}

					// Check if the punch-out and punch-in are on the same day
					if (pOutOfCurrent.toLocalDate().getDayOfMonth() == pInOfNext.toLocalDate().getDayOfMonth()
							&& pOutOfCurrent != null && pInOfNext != null) {
						// Calculate the punch-out to punch-in time difference in minutes
						punchout += Duration.between(pOutOfCurrent, pInOfNext).toMinutes();
					}
					dateOnly = pInOfCurrent;
					// Add unique dates to the noofDays list
					if (!noofDays.contains(dateOnly.toLocalDate().atStartOfDay()))
						noofDays.add(dateOnly.toLocalDate().atStartOfDay());

				}
				if ((LocalDateTime) punchData.get(i)[0] != null && (LocalDateTime) punchData.get(i)[1] != null) {
					// Calculate the punch-in time and date for the last entry
					punchin += Duration
							.between((LocalDateTime) punchData.get(i)[0], (LocalDateTime) punchData.get(i)[1])
							.toMinutes();
				}
				dateOnly = (LocalDateTime) punchData.get(i)[0];
				if (!noofDays.contains(dateOnly.toLocalDate().atStartOfDay()))
					noofDays.add(dateOnly.toLocalDate().atStartOfDay());

				// Calculate the average punch-in and punch-out times
				result.add(punchin / noofDays.size());
				result.add(punchout / noofDays.size());

			}

			logger.info("successfully calculated the average punch data");

			return result;

		} catch (Exception e) {
			logger.error("Failed to get Average Punch data");
			return Collections.emptyList();
		}
	}

	@Override
	public void processExcelFile(MultipartFile file) throws IOException {
		try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {

			// Get the first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// Create an iterator to iterate over the rows of the sheet
			Iterator<Row> rowIterator = sheet.iterator();

			rowIterator.next(); // Skip header row

			// iterate over each row
			while (rowIterator.hasNext()) {

				// get next row
				Row row = rowIterator.next();

				// Assuming column order: employeeId, punchIn, punchOut, punchSystem
				// retrieve respective data from the excel
				Integer employeeId = (int) row.getCell(0).getNumericCellValue();
				LocalDateTime punchIn = convertToDateTime(row.getCell(1));
				LocalDateTime punchOut = convertToDateTime(row.getCell(2));
				String punchSystem = row.getCell(3).toString();

				logger.info("Processing attendance record for employee ID");

				// set the data to the model
				attendance.setPunchIn(punchIn);
				attendance.setPunchOut(punchOut);
				attendance.setPunchSystem(punchSystem);
				attendanceId.setEmployeeId(employeeId);

				// generate next index for the record
				int nextIndex = employeeAttendanceDAO.getNextAttendanceRequestIndex(employeeId);
				attendanceId.setEmplPIndex(nextIndex);
				attendance.setAttendanceId(attendanceId);

				System.out.println(attendanceId.getEmployeeId());
				System.out.println(attendanceId.getEmplPIndex());

				// insert the record into database using service
				insertEmployeeAttendance(attendance);

				logger.info("Attendance record processed for employee.");

			}
		} catch (IOException e) {
			throw e;
		}
	}

}
