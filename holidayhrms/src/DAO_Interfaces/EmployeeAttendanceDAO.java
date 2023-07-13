package DAO_Interfaces;

import java.util.List;

import models.EmployeeAttendance;

public interface EmployeeAttendanceDAO {

	/**
	 * Saves the employee attendance record to the database.
	 * 
	 * @param employeeAttendance The employee attendance object to be saved.
	 */
	void save(EmployeeAttendance employeeAttendance);

	/**
	 * Retrieves the next attendance request index for the given employee ID.
	 * 
	 * @param employeeId The ID of the employee.
	 * @return The next attendance request index.
	 */
	int getNextAttendanceRequestIndex(int employeeId);

	/**
	 * Retrieves the punch-in and punch-out data for yesterday for the given employee ID.
	 * 
	 * @param employeeId The ID of the employee.
	 * @return A list of object arrays containing the punch-in and punch-out data for yesterday. Each object array
	 *         represents a record and contains two elements: punch-in and punch-out.
	 */
	List<Object[]> getYesterdayPunchInAndPunchOut(int employeeId);

	/**
	 * Retrieves the punch-in and punch-out data for the specified year, month, and employee ID.
	 * 
	 * @param employeeId    The ID of the employee.
	 * @param selectedYear  The selected year.
	 * @param selectedMonth The selected month.
	 * @return A list of object arrays containing the punch-in and punch-out data for the specified year, month, and
	 *         employee. Each object array represents a record and contains two elements: punch-in and punch-out.
	 */
	List<Object[]> getPunchInAndPunchOutDataForYearAndMonthAndEmployee(int employeeId, int selectedYear,
			int selectedMonth);
}
