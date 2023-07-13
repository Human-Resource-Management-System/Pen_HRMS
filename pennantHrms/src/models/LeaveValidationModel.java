package models;

public class LeaveValidationModel {
	private int allowedTotalLeaves;
	private int allowedSickLeaves;
	private int allowedCasualLeaves;
	private int allowedOtherLeaves;
	private long takenTotalLeaves;
	private long takenSickLeaves;
	private long takenCasualLeaves;
	private long takenOtherLeaves;

	private long pendingTotalNoOfLeaves = 0;
	private long pendingSickLeaves = 0;
	private long pendingCasualLeaves = 0;
	private long pendingOtherLeaves = 0;

	public long getPendingTotalNoOfLeaves() {
		return pendingTotalNoOfLeaves;
	}

	public void setPendingTotalNoOfLeaves(long pendingTotalNoOfLeaves) {
		this.pendingTotalNoOfLeaves = pendingTotalNoOfLeaves;
	}

	public long getPendingSickLeaves() {
		return pendingSickLeaves;
	}

	public void setPendingSickLeaves(long pendingSickLeaves) {
		this.pendingSickLeaves = pendingSickLeaves;
	}

	public long getPendingCasualLeaves() {
		return pendingCasualLeaves;
	}

	public void setPendingCasualLeaves(long pendingCasualLeaves) {
		this.pendingCasualLeaves = pendingCasualLeaves;
	}

	public long getPendingOtherLeaves() {
		return pendingOtherLeaves;
	}

	public void setPendingOtherLeaves(long pendingOtherLeaves) {
		this.pendingOtherLeaves = pendingOtherLeaves;
	}

	public int getAllowedTotalLeaves() {
		return allowedTotalLeaves;
	}

	public void setAllowedTotalLeaves(int allowedTotalLeaves) {
		this.allowedTotalLeaves = allowedTotalLeaves;
	}

	public int getAllowedSickLeaves() {
		return allowedSickLeaves;
	}

	public void setAllowedSickLeaves(int allowedSickLeaves) {
		this.allowedSickLeaves = allowedSickLeaves;
	}

	public int getAllowedCasualLeaves() {
		return allowedCasualLeaves;
	}

	public void setAllowedCasualLeaves(int allowedCasualLeaves) {
		this.allowedCasualLeaves = allowedCasualLeaves;
	}

	public int getAllowedOtherLeaves() {
		return allowedOtherLeaves;
	}

	public void setAllowedOtherLeaves(int allowedOtherLeaves) {
		this.allowedOtherLeaves = allowedOtherLeaves;
	}

	public long getTakenTotalLeaves() {
		return takenTotalLeaves;
	}

	public void setTakenTotalLeaves(long takenTotalLeaves) {
		this.takenTotalLeaves = takenTotalLeaves;
	}

	public long getTakenSickLeaves() {
		return takenSickLeaves;
	}

	public void setTakenSickLeaves(long takenSickLeaves) {
		this.takenSickLeaves = takenSickLeaves;
	}

	public long getTakenCasualLeaves() {
		return takenCasualLeaves;
	}

	public void setTakenCasualLeaves(long takenCasualLeaves) {
		this.takenCasualLeaves = takenCasualLeaves;
	}

	public long getTakenOtherLeaves() {
		return takenOtherLeaves;
	}

	public void setTakenOtherLeaves(long takenOtherLeaves) {
		this.takenOtherLeaves = takenOtherLeaves;
	}

	public LeaveValidationModel(int allowedTotalLeaves, int allowedSickLeaves, int allowedCasualLeaves,
			int allowedOtherLeaves, long takenTotalLeaves, long takenSickLeaves, long takenCasualLeaves,
			long takenOtherLeaves, long pendingTotalNoOfLeaves, long pendingSickLeaves, long pendingCasualLeaves,
			long pendingOtherLeaves) {
		this.allowedTotalLeaves = allowedTotalLeaves;
		this.allowedSickLeaves = allowedSickLeaves;
		this.allowedCasualLeaves = allowedCasualLeaves;
		this.allowedOtherLeaves = allowedOtherLeaves;
		this.takenTotalLeaves = takenTotalLeaves;
		this.takenSickLeaves = takenSickLeaves;
		this.takenCasualLeaves = takenCasualLeaves;
		this.takenOtherLeaves = takenOtherLeaves;
		this.pendingTotalNoOfLeaves = pendingTotalNoOfLeaves;
		this.pendingSickLeaves = pendingSickLeaves;
		this.pendingCasualLeaves = pendingCasualLeaves;
		this.pendingOtherLeaves = pendingOtherLeaves;
	}

	public LeaveValidationModel() {
	}

}
