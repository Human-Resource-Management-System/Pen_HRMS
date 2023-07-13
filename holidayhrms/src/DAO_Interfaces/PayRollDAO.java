package DAO_Interfaces;

import models.EmployeePayslip;

/**
 * 
 * The PayRollDAO interface provides methods to interact with the database for payroll-related operations.
 */
public interface PayRollDAO {

	/**
	 * 
	 * Inserts an employee payslip into the database.
	 * 
	 * @param payslip The employee payslip to be inserted.
	 */
	void insertEmployeePayslip(EmployeePayslip payslip);

	/**
	 * 
	 * Retrieves the employee payslips for a given employee ID.
	 * 
	 * @param employeeId The ID of the employee.
	 * @return The employee payslip associated with the employee ID.
	 */
	public EmployeePayslip getEmployeePayslipsByEmployeeId(int employeeId);

	/**
	 * 
	 * Retrieves the employee payslip for a given employee ID and month-year.
	 * 
	 * @param employeeId The ID of the employee.
	 * @param monthYear  The month and year in the format "MMYYYY" representing the payslip's month-year.
	 * @return The employee payslip associated with the employee ID and month-year.
	 */
	public EmployeePayslip getEmployeePayslipsByEmployeeIdAndMonthYear(int employeeId, String monthYear);
}
