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
@Table(name="gn_customer")
public class GnCustomer implements Serializable{

	private static final long serialVersionUID = -3484325385773610426L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name_ar")
	private String fullNameAr;
	
	@Column(name="full_name_en")
	private String fullNameEn;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	private WhoColumn whoColumn;
	
	public GnCustomer() {}

	public GnCustomer(String fullNameAr, String fullNameEn, String gender, String phoneNumber, String email,
			WhoColumn whoColumn) {
		super();
		this.fullNameAr = fullNameAr;
		this.fullNameEn = fullNameEn;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "GnCustomer [id=" + id + ", fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + ", email=" + email + ", whoColumn=" + whoColumn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	
	
}
