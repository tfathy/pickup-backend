package com.pickup.sysowner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name = "hr_employee")
public class HrEmployee implements Serializable {

	private static final long serialVersionUID = -1223095303965578710L;

	public HrEmployee() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private SysOwner sysOwner;

	@Column(name = "full_name_ar")
	private String fullNameAr;

	@Column(name = "full_name_en")
	private String fullNameEn;

	@Column(name = "notes")
	private String notes;

	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SysOwner getSysOwner() {
		return sysOwner;
	}

	public void setSysOwner(SysOwner sysOwner) {
		this.sysOwner = sysOwner;
	}

	public String getFullNameAr() {
		return fullNameAr;
	}

	public void setFullNameAr(String fullNameAr) {
		this.fullNameAr = fullNameAr;
	}

	public String getFullNameEn() {
		return fullNameEn;
	}

	public void setFullNameEn(String fullNameEn) {
		this.fullNameEn = fullNameEn;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	public HrEmployee(SysOwner sysOwner, String fullNameAr, String fullNameEn, String notes, WhoColumn whoColumn) {
		super();
		this.sysOwner = sysOwner;
		this.fullNameAr = fullNameAr;
		this.fullNameEn = fullNameEn;
		this.notes = notes;
		this.whoColumn = whoColumn;
	}

}
