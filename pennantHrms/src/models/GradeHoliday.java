package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_jobgradewiseholidays")
public class GradeHoliday {

	@Id
	@Column(name = "jbgr_id")
	private String jbgr_id;

	@Column(name = "jbgr_totalnoh")
	private int jbgr_totalnoh;

	public String getJbgr_id() {
		return jbgr_id;
	}

	public void setJbgr_id(String jbgr_id) {
		this.jbgr_id = jbgr_id;
	}

	public int getJbgr_totalnoh() {
		return jbgr_totalnoh;
	}

	public void setJbgr_totalnoh(int jbgr_totalnoh) {
		this.jbgr_totalnoh = jbgr_totalnoh;
	}

}