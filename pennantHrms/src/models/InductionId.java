package models;

import java.io.Serializable;
import java.util.Objects;

public class InductionId implements Serializable {

	private int indcId;
	private int indcEmofId;

	public int getIndcId() {
		return indcId;
	}

	public void setIndcId(int indcId) {
		this.indcId = indcId;
	}

	public int getIndcEmofId() {
		return indcEmofId;
	}

	public void setIndcEmofId(int indcEmofId) {
		this.indcEmofId = indcEmofId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InductionId that = (InductionId) o;
		return indcId == that.indcId && indcEmofId == that.indcEmofId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(indcId, indcEmofId);
	}
}
