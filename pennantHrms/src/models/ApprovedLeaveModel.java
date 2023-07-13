package models;

import java.time.LocalDate;

public class ApprovedLeaveModel {

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setApprovedStartDate(LocalDate approvedStartDate) {
		this.approvedStartDate = approvedStartDate;
	}

	public void setApprovedEndDate(LocalDate approvedEndDate) {
		this.approvedEndDate = approvedEndDate;
	}

	private int employeeId;
	private String employeeName;
	private LocalDate approvedStartDate;
	private LocalDate approvedEndDate;

	public ApprovedLeaveModel(int employeeId, String employeeName, LocalDate approvedStartDate,
			LocalDate approvedEndDate) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.approvedStartDate = approvedStartDate;
		this.approvedEndDate = approvedEndDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public LocalDate getApprovedStartDate() {
		return approvedStartDate;
	}

	public LocalDate getApprovedEndDate() {
		return approvedEndDate;
	}

	public ApprovedLeaveModel() {
	}
}
