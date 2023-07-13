package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_hrdept")
public class HRDepartment {

	@Id
	@Column(name = "empl_id")
	private int employeeId;

	@Column(name = "hrdp_role")
	private String role;

	@Column(name = "jbgr_id", insertable = false, updatable = false)
	private String jobGradeId;

	@Column(name = "hr_name")
	private String name;

	@Column(name = "hr_mobileno")
	private long mobileNumber;

	@Column(name = "hr_email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "jbgr_id", referencedColumnName = "jbgr_id", insertable = false, updatable = false)
	private HrmsJobGrade jobGrade;

	// Constructors, getters, and setters

	public HRDepartment() {
	}

	public HRDepartment(String role, String jobGradeId, String name, long mobileNumber, String email) {
		this.role = role;
		this.jobGradeId = jobGradeId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	// Other methods

	// Getters and setters

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJobGradeId() {
		return jobGradeId;
	}

	public void setJobGradeId(String jobGradeId) {
		this.jobGradeId = jobGradeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HrmsJobGrade getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(HrmsJobGrade jobGrade) {
		this.jobGrade = jobGrade;
	}
}
