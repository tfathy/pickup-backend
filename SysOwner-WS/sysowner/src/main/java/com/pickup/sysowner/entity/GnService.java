package com.pickup.sysowner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity
@Table(name = "gn_service")
public class GnService implements Serializable {

	private static final long serialVersionUID = -5603730410552163709L;

	public GnService() {

	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "code")
	private String code;

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

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "GnService [id=" + id + ", descEn=" + descEn + ", descAr=" + descAr + ", code=" + code + ", activeFlag="
				+ activeFlag + ", whoColumn=" + whoColumn + "]";
	}

	public GnService(String descEn, String descAr, String code, String activeFlag, WhoColumn whoColumn) {
		super();
		this.descEn = descEn;
		this.descAr = descAr;
		this.code = code;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}

}
