package models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employeepayslips")
@IdClass(EmployeePayslipId.class)
public class EmployeePayslip implements Serializable {

	@Id
	@Column(name = "empl_id")
	private int employeeId;

	@Id
	@Column(name = "empl_monthyear")
	private String monthYear;

	@Column(name = "empl_basic")
	private double basicSalary;

	@Column(name = "empl_hra")
	private double hra;

	@Column(name = "empl_da")
	private double da;

	@Column(name = "empl_ta")
	private double ta;

	@Column(name = "empl_additions")
	private double additions;

	@Column(name = "empl_deductions")
	private double deductions;

	@Column(name = "empl_ptax")
	private double ptax;

	@Column(name = "empl_pf")
	private double pf;

	@Column(name = "empl_esi")
	private double esi;

	@Column(name = "empl_gratituty")
	private double gratuity;

	@Column(name = "empl_tds")
	private double tds;

	@Column(name = "empl_luudate")
	private Timestamp lastUpdatedDate;

	@Column(name = "empl_luuser")
	private int lastUpdatedUser;

	// Constructors, getters, and setters

	public EmployeePayslip() {
	}

	public EmployeePayslip(int employeeId, String monthYear, double basicSalary, double hra, double da, double ta,
			double additions, double deductions, double ptax, double pf, double esi, double gratuity, double tds,
			Timestamp lastUpdatedDate, int lastUpdatedUser) {
		this.employeeId = employeeId;
		this.monthYear = monthYear;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.da = da;
		this.ta = ta;
		this.additions = additions;
		this.deductions = deductions;
		this.ptax = ptax;
		this.pf = pf;
		this.esi = esi;
		this.gratuity = gratuity;
		this.tds = tds;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedUser = lastUpdatedUser;
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

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getTa() {
		return ta;
	}

	public void setTa(double ta) {
		this.ta = ta;
	}

	public double getAdditions() {
		return additions;
	}

	public void setAdditions(double additions) {
		this.additions = additions;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getPtax() {
		return ptax;
	}

	public void setPtax(double ptax) {
		this.ptax = ptax;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getEsi() {
		return esi;
	}

	public void setEsi(double esi) {
		this.esi = esi;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	public double getTds() {
		return tds;
	}

	public void setTds(double tds) {
		this.tds = tds;
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

	// Equals and hashCode methods

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeePayslip that = (EmployeePayslip) o;
		return employeeId == that.employeeId && Objects.equals(monthYear, that.monthYear);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, monthYear);
	}
}
