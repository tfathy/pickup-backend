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
@Entity()
@Table(name="gn_currency")
public class GnCurrency implements Serializable{


	private static final long serialVersionUID = -8730358661997968536L;
	public GnCurrency() {
		
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name_ar")
	private String nameAr;
	
	@Column(name="name_en")
	private String nameEn;
	
	@Column(name="code")
	private String code;
	
	@Column(name="cur_symbol")
	private String curSymbol;
	
	@Column(name="decimil_point")
	private Integer decimilPoint;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Column(name="status")
	private String status;
	
	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurSymbol() {
		return curSymbol;
	}

	public void setCurSymbol(String curSymbol) {
		this.curSymbol = curSymbol;
	}

	public Integer getDecimilPoint() {
		return decimilPoint;
	}

	public void setDecimilPoint(Integer decimilPoint) {
		this.decimilPoint = decimilPoint;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "GnCurrency [id=" + id + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", code=" + code + ", curSymbol="
				+ curSymbol + ", decimilPoint=" + decimilPoint + ", activeFlag=" + activeFlag + ", status=" + status
				+ ", whoColumn=" + whoColumn + "]";
	}

	public GnCurrency(String nameAr, String nameEn, String code, String curSymbol, Integer decimilPoint,
			String activeFlag, String status, WhoColumn whoColumn) {
		super();
		this.nameAr = nameAr;
		this.nameEn = nameEn;
		this.code = code;
		this.curSymbol = curSymbol;
		this.decimilPoint = decimilPoint;
		this.activeFlag = activeFlag;
		this.status = status;
		this.whoColumn = whoColumn;
	}
	
	
	

}
