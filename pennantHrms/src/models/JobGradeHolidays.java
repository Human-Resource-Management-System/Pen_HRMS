package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_jobgradewiseholidays")
public class JobGradeHolidays {
	@Id
	@Column(name = "jbgr_id")
	private String jbgrId;

	public String getJbgrId() {
		return jbgrId;
	}

	public void setJbgrId(String jbgrId) {
		this.jbgrId = jbgrId;
	}

	public int getJbgr_totalnoh() {
		return jbgr_totalnoh;
	}

	public void setJbgr_totalnoh(int jbgr_totalnoh) {
		this.jbgr_totalnoh = jbgr_totalnoh;
	}

	private int jbgr_totalnoh;

	// Other job grade holidays properties

	// Getters and setters
}
