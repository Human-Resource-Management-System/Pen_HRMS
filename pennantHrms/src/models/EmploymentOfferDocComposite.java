package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmploymentOfferDocComposite implements Serializable {

	@Override
	public String toString() {
		return "EmploymentOfferDocComposite [offerid=" + offerid + ", documentIndex=" + documentIndex + "]";
	}

	@Column(name = "eofd_id")
	private int offerid;

	@Column(name = "eofd_docindex")
	private int documentIndex;

	public int getOfferid() {
		return offerid;
	}

	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}

	public int getDocumentIndex() {
		return documentIndex;
	}

	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}

}