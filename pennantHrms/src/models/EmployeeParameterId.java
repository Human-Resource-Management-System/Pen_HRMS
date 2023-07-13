package models;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeParameterId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private int parameterId;

	// Constructors, equals, and hashCode

	public EmployeeParameterId() {
	}

	public EmployeeParameterId(int employeeId, int parameterId) {
		this.employeeId = employeeId;
		this.parameterId = parameterId;
	}

	// Equals and hashCode methods

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeeParameterId that = (EmployeeParameterId) o;
		return employeeId == that.employeeId && parameterId == that.parameterId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, parameterId);
	}
}
