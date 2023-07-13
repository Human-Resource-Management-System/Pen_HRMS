package models.input.output;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class DocumentInputModel {

	@NotEmpty
	private String category;
	private MultipartFile documentData;

	public DocumentInputModel() {

	}

	public DocumentInputModel(String category, MultipartFile documentData) {

		this.category = category;
		this.documentData = documentData;
	}

	@NotEmpty
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public MultipartFile getDocumentData() {
		return documentData;
	}

	public void setDocumentData(MultipartFile documentData) {
		this.documentData = documentData;
	}
}
