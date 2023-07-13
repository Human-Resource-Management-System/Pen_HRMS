package models.input.output;

public class JobGradeLeavesOutModel {
	private String jobGradeId;
	private int totalLeaves;
	private int casualLeaves;
	private int sickLeaves;
	private int otherLeaves;

	public String getJobGradeId() {
		return jobGradeId;
	}

	public void setJobGradeId(String jobGradeId) {
		this.jobGradeId = jobGradeId;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public int getCasualLeaves() {
		return casualLeaves;
	}

	public void setCasualLeaves(int casualLeaves) {
		this.casualLeaves = casualLeaves;
	}

	public int getSickLeaves() {
		return sickLeaves;
	}

	public void setSickLeaves(int sickLeaves) {
		this.sickLeaves = sickLeaves;
	}

	public int getOtherLeaves() {
		return otherLeaves;
	}

	public void setOtherLeaves(int otherLeaves) {
		this.otherLeaves = otherLeaves;
	}
}