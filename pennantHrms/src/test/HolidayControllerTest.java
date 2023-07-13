package test;

import controllers.HolidayController;
import DAO.HolidayDAOImpl;
import DAO_Interfaces.EmployeeDAO;
import DAO_Interfaces.EmployeeOptedLeavesDAO;
import DAO_Interfaces.HolidayDAO;
import DAO_Interfaces.JobGradeHolidaysDAO;
import exceptions.EmployeeNotFoundException;
import models.Employee;
import models.EmployeeOptedLeaves;
import models.EmployeeOptedLeavesId;
import models.GradeHoliday;
import models.Holiday;
import models.HrmsJobGrade;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.mockito.Mockito;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.JobGradeHolidays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class HolidayControllerTest {
    @Mock
    private HolidayDAO holidayDAO;

    @Mock
    private EmployeeDAO employeeDAO;

    @Mock
    private JobGradeHolidaysDAO jobGradeHolidaysDAO;

    @Mock
    private EmployeeOptedLeavesDAO employeeOptedLeavesDAO;

    @Mock
    private HrmsJobGrade jobGrade;

    @Mock
    private HttpSession session;

    @InjectMocks
    private HolidayController holidayController;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowHolidays() {
        List<Holiday> holidays = new ArrayList<>();
        when(holidayDAO.findAllHolidays()).thenReturn(holidays);

        Model model = Mockito.mock(Model.class); // Create a mock instance of Model

        holidayController.showHolidays(model);

        verify(holidayDAO, times(1)).findAllHolidays();
    }

    @Test(expectedExceptions = EmployeeNotFoundException.class)
    public void testDisplayEmployeeInformation_ThrowsEmployeeNotFoundException() {
        int emplId = 1;
        when(session.getAttribute("employeeId")).thenReturn(emplId);
        when(employeeDAO.getEmployeeById(emplId)).thenReturn(null);

        holidayController.displayEmployeeInformation(null, session);
    }

    @Test
    public void testDisplayEmployeeInformation() {
        int emplId = 1;
        when(session.getAttribute("employeeId")).thenReturn(emplId);
        Employee employee = new Employee();
        when(employeeDAO.getEmployeeById(emplId)).thenReturn(employee);
        int currentYear = LocalDate.now().getYear();
        when(holidayDAO.getEmployeeoptionalholidaysCount(eq(emplId), eq(currentYear))).thenReturn(0L);
        JobGradeHolidays jobGradeHolidays = new JobGradeHolidays();
        when(jobGradeHolidaysDAO.getJobGradeHolidaysByGrade(any())).thenReturn(jobGradeHolidays);
        List<Holiday> holidays = new ArrayList<>();
        when(holidayDAO.findAlloptedHolidays()).thenReturn(holidays);
        int mandholidays = 0;
        when(holidayDAO.countMandHolidays()).thenReturn(mandholidays);

        Model model = Mockito.mock(Model.class); // Create a mock instance of Model

        holidayController.displayEmployeeInformation(model, session);

        verify(session, times(1)).getAttribute("employeeId");
        verify(employeeDAO, times(1)).getEmployeeById(emplId);
        verify(holidayDAO, times(1)).getEmployeeoptionalholidaysCount(emplId, currentYear);
        verify(jobGradeHolidaysDAO, times(1)).getJobGradeHolidaysByGrade(any());
        verify(holidayDAO, times(1)).findAlloptedHolidays();
        verify(holidayDAO, times(1)).countMandHolidays();
    }


    @Test
    public void testSubmitSelectedHolidays() {
        List<String> selectedHolidays = new ArrayList<>();
        int emplId = 1;

        ResponseEntity<String> response = holidayController.submitSelectedHolidays(selectedHolidays, emplId);

        verify(employeeOptedLeavesDAO, times(selectedHolidays.size())).saveEmployeeOptedLeaves(any());

        assert response.getStatusCode() == HttpStatus.OK;
    }


}
