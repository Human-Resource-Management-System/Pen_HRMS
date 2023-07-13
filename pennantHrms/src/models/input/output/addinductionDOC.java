package models.input.output;

import java.io.File;

public class addinductionDOC {
	private int employmentOfferId;
	private int documentTypeId;
	private File documentData;
	private int processedUserId;
	private String verified;

	public addinductionDOC() {
		// Default constructor
	}

	public addinductionDOC(int employmentOfferId, int documentTypeId, File documentData, int processedUserId,
			String verified) {
		this.employmentOfferId = employmentOfferId;
		this.documentTypeId = documentTypeId;
		this.documentData = documentData;
		this.processedUserId = processedUserId;
		this.verified = verified;
	}

	public int getEmploymentOfferId() {
		return employmentOfferId;
	}

	public void setEmploymentOfferId(int employmentOfferId) {
		this.employmentOfferId = employmentOfferId;
	}

	public int getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public File getDocumentData() {
		return documentData;
	}

	public void setDocumentData(File documentData) {
		this.documentData = documentData;
	}

	public int getProcessedUserId() {
		return processedUserId;
	}

	public void setProcessedUserId(int processedUserId) {
		this.processedUserId = processedUserId;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

}
