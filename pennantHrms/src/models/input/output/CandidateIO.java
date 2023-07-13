package models.input.output;

import java.sql.Date;

public class CandidateIO {
	private Integer candId;
	private String candFirstName;
	private String candMiddleName;
	private String candLastName;
	private Date candRDate;
	private String candGender;
	private Date candDOB;
	private String candEmail;
	private Long candMobile;
	private String candAddress;
	private Date candLUDate;
	private String candStatus;

	// Getters and setters

	public Integer getCandId() {
		return candId;
	}

	public void setCandId(Integer candId) {
		this.candId = candId;
	}

	public String getCandFirstName() {
		return candFirstName;
	}

	public void setCandFirstName(String candFirstName) {
		this.candFirstName = candFirstName;
	}

	public String getCandMiddleName() {
		return candMiddleName;
	}

	public void setCandMiddleName(String candMiddleName) {
		this.candMiddleName = candMiddleName;
	}

	public String getCandLastName() {
		return candLastName;
	}

	public void setCandLastName(String candLastName) {
		this.candLastName = candLastName;
	}

	public Date getCandRDate() {
		return candRDate;
	}

	public void setCandRDate(Date candRDate) {
		this.candRDate = candRDate;
	}

	public String getCandGender() {
		return candGender;
	}

	public void setCandGender(String candGender) {
		this.candGender = candGender;
	}

	public Date getCandDOB() {
		return candDOB;
	}

	public void setCandDOB(Date candDOB) {
		this.candDOB = candDOB;
	}

	public String getCandEmail() {
		return candEmail;
	}

	public void setCandEmail(String candEmail) {
		this.candEmail = candEmail;
	}

	public Long getCandMobile() {
		return candMobile;
	}

	public void setCandMobile(Long candMobile) {
		this.candMobile = candMobile;
	}

	public String getCandAddress() {
		return candAddress;
	}

	public void setCandAddress(String candAddress) {
		this.candAddress = candAddress;
	}

	public Date getCandLUDate() {
		return candLUDate;
	}

	public void setCandLUDate(Date candLUDate) {
		this.candLUDate = candLUDate;
	}

	public String getCandStatus() {
		return candStatus;
	}

	public void setCandStatus(String candStatus) {
		this.candStatus = candStatus;
	}
}
