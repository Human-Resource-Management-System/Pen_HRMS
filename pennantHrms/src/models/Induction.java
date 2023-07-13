
package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_induction")
@IdClass(InductionId.class)
public class Induction {
	@Id
	@Column(name = "indc_id")
	private Integer indcId;

	@Id
	@Column(name = "indc_emof_id")
	private int indcEmofId;

	@Column(name = "indc_date")
	private Date indcDate;

	@Column(name = "indc_processes_ausr_id", nullable = true)
	private Integer indcProcessedAusrId;

	@Column(name = "indc_status")
	private String indcStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indc_emof_id", referencedColumnName = "eofr_cand_id", insertable = false, updatable = false)
	private HrmsEmploymentOffer employmentOffer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "indc_processes_ausr_id", referencedColumnName = "ausr_empl_id", insertable = false, updatable = false)
	private adminusers adminUser;

	public Integer getIndcId() {
		return indcId;
	}

	public void setIndcId(Integer indcId) {
		this.indcId = indcId;
	}

	public int getIndcEmofId() {
		return indcEmofId;
	}

	public void setIndcEmofId(int indcEmofId) {
		this.indcEmofId = indcEmofId;
	}

	@Override
	public String toString() {
		return "Induction [indcId=" + indcId + ", indcEmofId=" + indcEmofId + ", indcDate=" + indcDate
				+ ", indcProcessedAusrId=" + indcProcessedAusrId + ", indcStatus=" + indcStatus + ", employmentOffer="
				+ employmentOffer + ", adminUser=" + adminUser + "]";
	}

	public Date getIndcDate() {
		return indcDate;
	}

	public void setIndcDate(Date indcDate) {
		this.indcDate = indcDate;
	}

	public Integer getIndcProcessedAusrId() {
		return indcProcessedAusrId;
	}

	public void setIndcProcessedAusrId(Integer indcProcessedAusrId) {
		this.indcProcessedAusrId = indcProcessedAusrId;
	}

	public String getIndcStatus() {
		return indcStatus;
	}

	public void setIndcStatus(String indcStatus) {
		this.indcStatus = indcStatus;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		return employmentOffer;
	}

	public void setEmploymentOffer(HrmsEmploymentOffer employmentOffer) {
		this.employmentOffer = employmentOffer;
	}

	public adminusers getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(adminusers adminUser) {
		this.adminUser = adminUser;
	}

}
