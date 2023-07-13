package models.input.output;

public class EmployeePayRollInputModel {

	private int id;
	private String monthYear;
	private double basicPay;
	private double fixedPay;
	private double variablePay;
	private double gratuity;
	private double healthInsurance;
	private double pf;
	private double hra;
	private double da;
	private double ta;
	private double additions;
	private double deductions;
	private double ptax;
	private double esi;
	private double tds;

	public EmployeePayRollInputModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getmonthYear() {
		return monthYear;
	}

	public void setmonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getFixedPay() {
		return fixedPay;
	}

	public void setFixedPay(double fixedPay) {
		this.fixedPay = fixedPay;
	}

	public double getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(double variablePay) {
		this.variablePay = variablePay;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	public double getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(double healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
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

	public double getEsi() {
		return esi;
	}

	public void setEsi(double esi) {
		this.esi = esi;
	}

	public double getTds() {
		return tds;
	}

	public void setTds(double tds) {
		this.tds = tds;
	}
}
