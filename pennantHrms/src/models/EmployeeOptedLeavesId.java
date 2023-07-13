package models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeOptedLeavesId implements Serializable {

	@Column(name = "empl_id")
	private int employeeId;

	@Column(name = "eolv_date")
	private Date holidayDate; // Update import to java.sql.Date

	// Constructors

	public EmployeeOptedLeavesId() {
		// Default constructor
	}

	public EmployeeOptedLeavesId(int employeeId, Date holidayDate) {
		this.employeeId = employeeId;
		this.holidayDate = holidayDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}
}
