package DAO_Interfaces;

import java.util.List;

import javax.servlet.http.HttpSession;

import models.Employee;
import models.EmployeeParameter;

public interface EmployeeDAO {

	// To get all employees list
	List<Employee> getAllEmployees(HttpSession session);

	// To get employee details by id
	Employee getEmployeeById(int id);

	// To insert the employee details into database
	void insertEmployee(Employee employee);

	// To implement employee soft delete
	void updateEmployeeStatus(int id, String newStatus);

	// To update the details of the employee
	void updateEmployee(Employee employee);

	// To display employee parameter list
	List<EmployeeParameter> getEmployeeParametersById(Integer employeeId);

	// To display employee list grouped by HR and Manager
	List<Employee> getEmployeesByHRAndManager(int employeeId);

	// To get employee details by id
	Employee getEmployee(int employeeId);

	// To display list of employees
	List<Employee> getAllEmployees();

}
