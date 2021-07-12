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
import javax.persistence.Table;

import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name = "sp_member")
public class SpMember implements Serializable {
	private static final long serialVersionUID = 5726502710516005739L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "job_id")
	private SpJob spJob;

	@Column(name = "full_name_ar")
	private String fullNameAr;

	@Column(name = "full_name_en")
	private String fullNameEn;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "image_file_name")
	private String imageFileName;

	@Column(name = "driving_licn_exp_date")
	private String drivingLicnExpDate;

	@Column(name = "phone_num")
	private String phoneNum;

	@Column(name = "email")
	private String email;

	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "terminated_flag")
	private String terminatedFlag;

	@Embedded
	private WhoColumn whoColumn;

	public SpMember() {

	}

	public SpMember(SpJob spJob, String fullNameAr, String fullNameEn, String gender, Date birthDate,
			String imageFileName, String drivingLicnExpDate, String phoneNum, String email, Date hireDate,
			String terminatedFlag, WhoColumn whoColumn) {
		super();
		this.spJob = spJob;
		this.fullNameAr = fullNameAr;
		this.fullNameEn = fullNameEn;
		this.gender = gender;
		this.birthDate = birthDate;
		this.imageFileName = imageFileName;
		this.drivingLicnExpDate = drivingLicnExpDate;
		this.phoneNum = phoneNum;
		this.email = email;
		this.hireDate = hireDate;
		this.terminatedFlag = terminatedFlag;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SpMember [id=" + id + ", spJob=" + spJob + ", fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn
				+ ", gender=" + gender + ", birthDate=" + birthDate + ", imageFileName=" + imageFileName
				+ ", drivingLicnExpDate=" + drivingLicnExpDate + ", phoneNum=" + phoneNum + ", email=" + email
				+ ", hireDate=" + hireDate + ", terminatedFlag=" + terminatedFlag + ", whoColumn=" + whoColumn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SpJob getSpJob() {
		return spJob;
	}

	public void setSpJob(SpJob spJob) {
		this.spJob = spJob;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getDrivingLicnExpDate() {
		return drivingLicnExpDate;
	}

	public void setDrivingLicnExpDate(String drivingLicnExpDate) {
		this.drivingLicnExpDate = drivingLicnExpDate;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getTerminatedFlag() {
		return terminatedFlag;
	}

	public void setTerminatedFlag(String terminatedFlag) {
		this.terminatedFlag = terminatedFlag;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

}
