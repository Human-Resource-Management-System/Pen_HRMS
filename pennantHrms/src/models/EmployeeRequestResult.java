package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class EmployeeRequestResult {

	public Map<LocalDateTime, Duration> getAttendanceData() {
		return attendanceData;
	}

	public void setAttendanceData(Map<LocalDateTime, Duration> attendanceData) {
		this.attendanceData = attendanceData;
	}

	private String employeename;
	private int totaldays;
	private int dayswithminhrs;
	private double percentage;
	private Map<LocalDateTime, Duration> attendanceData;

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public EmployeeRequestResult() {

	}

	public String getEmployeename() {
		return employeename;
	}

	public int getTotaldays() {
		return totaldays;
	}

	public int getDayswithminhrs() {
		return dayswithminhrs;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
	}

	public void setDayswithminhrs(int dayswithminhrs) {
		this.dayswithminhrs = dayswithminhrs;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
