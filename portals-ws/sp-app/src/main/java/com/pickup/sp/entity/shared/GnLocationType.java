package com.pickup.sp.entity.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="gn_location_type")
public class GnLocationType implements Serializable{

	private static final long serialVersionUID = 7520770928465361190L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="active_flag")
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
		return "GnLocationType [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", activeFlag=" + activeFlag
				+ ", whoColumn=" + whoColumn + "]";
	}

	public GnLocationType(String descAr, String descEn, String activeFlag, WhoColumn whoColumn) {
		super();
		this.descAr = descAr;
		this.descEn = descEn;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}
}
