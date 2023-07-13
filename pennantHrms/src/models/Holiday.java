package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_holidays")
public class Holiday {

	@Column(name = "year_id")
	private int year_id;
	@Id
	@Column(name = "hday_date")
	private Date hday_date;

	@Column(name = "hday_title")
	private String hday_title;

	@Column(name = "hday_type")
	private String hday_type;

	// Getters and setters

	public int getYear() {
		return year_id;
	}

	public void setYear(int year) {
		this.year_id = year;
	}

	public Date gethday_date() {
		return hday_date;
	}

	public void sethday_date(Date hday_date) {
		this.hday_date = hday_date;
	}

	public String gethday_title() {
		return hday_title;
	}

	public void sethday_title(String hday_title) {
		this.hday_title = hday_title;
	}

	public String gethday_type() {
		return hday_type;
	}

	public void sethday_type(String hday_type) {
		this.hday_type = hday_type;
	}
}