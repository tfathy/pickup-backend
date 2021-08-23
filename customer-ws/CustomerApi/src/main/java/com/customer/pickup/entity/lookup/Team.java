package com.customer.pickup.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.customer.pickup.entity.shared.WhoColumn;

@Entity
@Table(name="sl_team")
public class Team implements Serializable{

	/**
	 * 
	 * the class should contains more attributes:  SpMember 'for manager' ,SpServiceProvider,GnVehicle
	 */
	private static final long serialVersionUID = -9025070099318813894L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "active_flag")
	private String activeFlag;

	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", activeFlag=" + activeFlag + ", whoColumn=" + whoColumn + "]";
	}

	public Team(String descAr, String descEn, Date startDate, Date endDate, String activeFlag, WhoColumn whoColumn) {
		super();
		this.descAr = descAr;
		this.descEn = descEn;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
