package models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employeeoptedleaves")
public class EmployeeOptedLeaves {

	@EmbeddedId
	private EmployeeOptedLeavesId optedleavesId;

	@Column(name = "year_id")
	private int year_id;

	public EmployeeOptedLeaves() {
	}

	public EmployeeOptedLeaves(EmployeeOptedLeavesId optedleavesId, int year_id) {
		super();
		this.optedleavesId = optedleavesId;
		this.year_id = year_id;
	}

	public EmployeeOptedLeavesId getOptedleavesId() {
		return optedleavesId;
	}

	public void setOptedleavesId(EmployeeOptedLeavesId optedleavesId) {
		this.optedleavesId = optedleavesId;
	}

	public int getYear_id() {
		return year_id;
	}

	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}
}
