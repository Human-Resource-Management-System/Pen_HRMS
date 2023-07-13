package models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeePayslipId implements Serializable {

	@Column(name = "empl_id")
	private int employeeId;

	@Column(name = "empl_monthyear")
	private String monthYear;

	// Constructors, getters, and setters

	public EmployeePayslipId() {
	}

	public EmployeePayslipId(int employeeId, String monthYear) {
		this.employeeId = employeeId;
		this.monthYear = monthYear;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	// Equals and hashCode methods

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeePayslipId that = (EmployeePayslipId) o;
		return employeeId == that.employeeId && Objects.equals(monthYear, that.monthYear);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, monthYear);
	}
}
