package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobGradeWiseLeaves")
public class JobGradeWiseLeaves {

	@Override
	public String toString() {
		return "JobGradeWiseLeaves [jbgrId=" + jbgrId + ", totalLeavesPerYear=" + totalLeavesPerYear
				+ ", casualLeavesPerYear=" + casualLeavesPerYear + ", sickLeavesPerYear=" + sickLeavesPerYear
				+ ", otherLeavesPerYear=" + otherLeavesPerYear + "]";
	}

	public JobGradeWiseLeaves(String jbgrId, int totalLeavesPerYear, int casualLeavesPerYear, int sickLeavesPerYear,
			int otherLeavesPerYear) {
		this.jbgrId = jbgrId;
		this.totalLeavesPerYear = totalLeavesPerYear;
		this.casualLeavesPerYear = casualLeavesPerYear;
		this.sickLeavesPerYear = sickLeavesPerYear;
		this.otherLeavesPerYear = otherLeavesPerYear;
	}

	public JobGradeWiseLeaves() {
	}

	@Id
	@Column(name = "jbgr_id")
	private String jbgrId;

	@Column(name = "jbgr_totalnol")
	private int totalLeavesPerYear;

	@Column(name = "jbgr_nocl")
	private int casualLeavesPerYear;

	@Column(name = "jbgr_nosl")
	private int sickLeavesPerYear;

	@Column(name = "jbgr_nool")
	private int otherLeavesPerYear;

	public String getJbgrId() {
		return jbgrId;
	}

	public void setJbgrId(String jbgrId) {
		this.jbgrId = jbgrId;
	}

	public int getTotalLeavesPerYear() {
		return totalLeavesPerYear;
	}

	public void setTotalLeavesPerYear(int totalLeavesPerYear) {
		this.totalLeavesPerYear = totalLeavesPerYear;
	}

	public int getCasualLeavesPerYear() {
		return casualLeavesPerYear;
	}

	public void setCasualLeavesPerYear(int casualLeavesPerYear) {
		this.casualLeavesPerYear = casualLeavesPerYear;
	}

	public int getSickLeavesPerYear() {
		return sickLeavesPerYear;
	}

	public void setSickLeavesPerYear(int sickLeavesPerYear) {
		this.sickLeavesPerYear = sickLeavesPerYear;
	}

	public int getOtherLeavesPerYear() {
		return otherLeavesPerYear;
	}

	public void setOtherLeavesPerYear(int otherLeavesPerYear) {
		this.otherLeavesPerYear = otherLeavesPerYear;
	}

}
