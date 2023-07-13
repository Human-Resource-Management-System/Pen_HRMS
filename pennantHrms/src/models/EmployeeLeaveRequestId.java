package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeLeaveRequestId implements Serializable {

	@Column(name = "empl_id")
	private int employeeId;

	@Column(name = "elrq_index")
	private int leaveRequestIndex;

	// Constructors

	public EmployeeLeaveRequestId() {
		// Default constructor
	}

	public EmployeeLeaveRequestId(int employeeId, int leaveRequestIndex) {
		this.employeeId = employeeId;
		this.leaveRequestIndex = leaveRequestIndex;
	}

	// Getters and Setters

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getLeaveRequestIndex() {
		return leaveRequestIndex;
	}

	public void setLeaveRequestIndex(int leaveRequestIndex) {
		this.leaveRequestIndex = leaveRequestIndex;
	}

	// Additional methods, if needed

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EmployeeLeaveRequestId that = (EmployeeLeaveRequestId) o;

		if (employeeId != that.employeeId)
			return false;
		return leaveRequestIndex == that.leaveRequestIndex;
	}

	@Override
	public int hashCode() {
		int result = employeeId;
		result = 31 * result + leaveRequestIndex;
		return result;
	}
}
