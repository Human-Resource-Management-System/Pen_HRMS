package service_interfaces;

/**
 * 
 * The PayRollService interface provides methods to calculate various components of payroll and total pay.
 */
public interface PayRollService {

	/**
	 * 
	 * Calculates the basic pay based on the given fixed pay.
	 * 
	 * @param fixedPay The fixed pay.
	 * @return The calculated basic pay.
	 */
	double calculateBasicPay(double fixedPay, int month);

	/**
	 * 
	 * Calculates the House Rent Allowance (HRA) based on the given fixed pay.
	 * 
	 * @param fixedPay The fixed pay.
	 * @return The calculated HRA.
	 */
	double calculateHRA(double fixedPay);

	/**
	 * 
	 * Calculates the Dearness Allowance (DA) based on the given fixed pay.
	 * 
	 * @param fixedPay The fixed pay.
	 * @return The calculated DA.
	 */
	double calculateDA(double fixedPay);

	/**
	 * 
	 * Calculates the Transport Allowance (TA) based on the given fixed pay.
	 * 
	 * @param fixedPay The fixed pay.
	 * @return The calculated TA.
	 */
	double calculateTA(double fixedPay);

	/**
	 * 
	 * Calculates the additional pay components.
	 * 
	 * @param additionalPay The additional pay.
	 * @return The calculated total of additional pay components.
	 */
	double calculateAdditions(double additionalPay);

	/**
	 * 
	 * Calculates the tax based on the Cost to Company (CTC).
	 * 
	 * @param ctc The Cost to Company.
	 * @return The calculated tax.
	 */
	double calculateTax(double ctc);

	/**
	 * 
	 * Calculates the Provident Fund (PF) based on the Cost to Company (CTC).
	 * 
	 * @param ctc The Cost to Company.
	 * @return The calculated PF.
	 */
	double calculatePF(double ctc);

	/**
	 * 
	 * Calculates the Employee State Insurance (ESI) based on the Cost to Company (CTC).
	 * 
	 * @param ctc The Cost to Company.
	 * @return The calculated ESI.
	 */
	double calculateESI(double ctc);

	/**
	 * 
	 * Calculates the gratuity based on the Cost to Company (CTC).
	 * 
	 * @param ctc The Cost to Company.
	 * @return The calculated gratuity.
	 */
	double calculateGratuity(double ctc);

	/**
	 * 
	 * Calculates the total deductions.
	 * 
	 * @return The calculated total deductions.
	 */
	double calculateDeductions();

	/**
	 * 
	 * Calculates the net pay.
	 * 
	 * @return The calculated net pay.
	 */
	double calculateNetPay();

	/**
	 * 
	 * Calculates the total pay.
	 * 
	 * @return The calculated total pay.
	 */
	double calculateTotalPay();

	public void getAttendancePayCutCount(int id, int year, int month);
}
