package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_employmentinductiondocuments")
public class EmploymentInductionDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emid_docindex")
	private int documentIndex;

	@Column(name = "empl_id")
	private int emplid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empl_id", referencedColumnName = "eofr_cand_id", insertable = false, updatable = false)
	private HrmsEmploymentOffer employmentOffer;

	@Column(name = "emid_idty_id")
	private int emplidty;

	@ManyToOne
	@JoinColumn(name = "emid_idty_id", referencedColumnName = "idty_id", insertable = false, updatable = false)
	private InductionDocumentTypes documentType;

	@Column(name = "emid_document")
	private String documentData;

	@Column(name = "emid_processed_ausr_id")
	private int indcProcessedAusrId;

	@ManyToOne
	@JoinColumn(name = "emid_processed_ausr_id", referencedColumnName = "ausr_empl_id", insertable = false, updatable = false)
	private adminusers processedUser;

	@Column(name = "emid_verified")
	private String verified;

	// Parameterized Constructor
	public EmploymentInductionDocument(int emplid, int emplidty, String documentData, int indcProcessedAusrId,
			String verified) {
		this.emplid = emplid;
		this.emplidty = emplidty;
		this.documentData = documentData;
		this.indcProcessedAusrId = indcProcessedAusrId;
		this.verified = verified;
	}

	// Default Constructor
	public EmploymentInductionDocument() {
	}

	public int getDocumentIndex() {
		return documentIndex;
	}

	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}

	public int getEmplid() {
		return emplid;
	}

	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}

	public int getEmplidty() {
		return emplidty;
	}

	public void setEmplidty(int emplidty) {
		this.emplidty = emplidty;
	}

	public String getDocumentData() {
		return documentData;
	}

	public void setDocumentData(String documentData) {
		this.documentData = documentData;
	}

	public int getIndcProcessedAusrId() {
		return indcProcessedAusrId;
	}

	public void setIndcProcessedAusrId(int indcProcessedAusrId) {
		this.indcProcessedAusrId = indcProcessedAusrId;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public HrmsEmploymentOffer getEmploymentOffer() {
		return employmentOffer;
	}

	public void setEmploymentOffer(HrmsEmploymentOffer employmentOffer) {
		this.employmentOffer = employmentOffer;
	}

	public InductionDocumentTypes getDocumentType() {
		return documentType;
	}

	public void setDocumentType(InductionDocumentTypes documentType) {
		this.documentType = documentType;
	}

	public adminusers getProcessedUser() {
		return processedUser;
	}

	public void setProcessedUser(adminusers processedUser) {
		this.processedUser = processedUser;
	}
}
