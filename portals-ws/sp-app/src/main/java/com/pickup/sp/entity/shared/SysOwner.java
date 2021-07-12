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
@Table(name = "sys_owner")
public class SysOwner implements Serializable {

	private static final long serialVersionUID = 257073723465208324L;

	public SysOwner() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "desc_ar")
	private String descAr;
	@Column(name = "desc_en")
	private String descEn;
	@Column(name = "address")
	private String address;
	@Column(name = "notes")
	private String notes;
	@Column(name = "short_name_ar")
	private String shortNameAr;
	@Column(name = "short_name_en")
	private String shortNameEn;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getShortNameAr() {
		return shortNameAr;
	}

	public void setShortNameAr(String shortNameAr) {
		this.shortNameAr = shortNameAr;
	}

	public String getShortNameEn() {
		return shortNameEn;
	}

	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SysOwner [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", address=" + address + ", notes="
				+ notes + ", shortNameAr=" + shortNameAr + ", shortNameEn=" + shortNameEn + ", whoColumn=" + whoColumn
				+ "]";
	}

	public SysOwner(String descAr, String descEn, String address, String notes, String shortNameAr, String shortNameEn,
			WhoColumn whoColumn) {
		super();
		this.descAr = descAr;
		this.descEn = descEn;
		this.address = address;
		this.notes = notes;
		this.shortNameAr = shortNameAr;
		this.shortNameEn = shortNameEn;
		this.whoColumn = whoColumn;
	}

	
}
