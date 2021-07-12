package com.pickup.sp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name="sl_team")
public class SlTeam implements Serializable{

	private static final long serialVersionUID = -3267830260768668075L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="manager_id")
	private SpMember manager;
	
	@ManyToOne
	@JoinColumn(name="sp_id")
	private SpServiceProvider sp;
	
	@OneToOne()
	@JoinColumn(name="vehicle_id")
	private GnVehicle gnVehicle;
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Embedded
	private WhoColumn whoColumn;
	public SlTeam() {
		
	}

	public SlTeam(SpMember manager, SpServiceProvider sp, GnVehicle gnVehicle, String descAr, String descEn,
			Date startDate, Date endDate, String activeFlag, WhoColumn whoColumn) {
		super();
		this.manager = manager;
		this.sp = sp;
		this.gnVehicle = gnVehicle;
		this.descAr = descAr;
		this.descEn = descEn;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SlTeam [id=" + id + ", manager=" + manager + ", sp=" + sp + ", gnVehicle=" + gnVehicle + ", descAr="
				+ descAr + ", descEn=" + descEn + ", startDate=" + startDate + ", endDate=" + endDate + ", activeFlag="
				+ activeFlag + ", whoColumn=" + whoColumn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SpMember getManager() {
		return manager;
	}

	public void setManager(SpMember manager) {
		this.manager = manager;
	}

	public SpServiceProvider getSp() {
		return sp;
	}

	public void setSp(SpServiceProvider sp) {
		this.sp = sp;
	}

	public GnVehicle getGnVehicle() {
		return gnVehicle;
	}

	public void setGnVehicle(GnVehicle gnVehicle) {
		this.gnVehicle = gnVehicle;
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
	
	
	
}
