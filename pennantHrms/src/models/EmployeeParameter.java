package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employeeparamaters")
@IdClass(EmployeeParameterId.class)
public class EmployeeParameter {
	@Id
	@Column(name = "empl_id")
	private Integer employeeId;

	@Id
	@Column(name = "empr_id")
	private Integer parameterId;

	@Column(name = "empr_name")
	private String parameterName;

	@Column(name = "empr_value")
	private String parameterValue;

	@Column(name = "empr_luudate")
	private Timestamp lastUpdatedDate;

	@Column(name = "empr_luuser")
	private int lastUpdatedUser;

	// Constructors, getters, and setters

	public EmployeeParameter() {
	}

	// Getters and setters

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getParameterId() {
		return parameterId;
	}

	public void setParameterId(Integer parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public int getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(int lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}
}
