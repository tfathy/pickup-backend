package com.pickup.security.sysowner.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pickup.security.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name="gn_country")
public class GnCountry implements Serializable{

	private static final long serialVersionUID = -6966967710902916521L;
	public GnCountry() {
		
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name_ar")
	private String nameAr;
	
	@Column(name="name_en")
	private String nameEn;
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "GnCountry [id=" + id + ", code=" + code + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", activeFlag="
				+ activeFlag + ", whoColumn=" + whoColumn + "]";
	}

	public GnCountry(String code, String nameAr, String nameEn, String activeFlag, WhoColumn whoColumn) {
		super();
		this.code = code;
		this.nameAr = nameAr;
		this.nameEn = nameEn;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}
	
	

}