package com.pickup.security.sysowner.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="sp_member")
public class SpMember implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7967584900492874509L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name_ar")
	private String fullNameAr;
	
	@Column(name="full_name_en")
	private String fullNameEn;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sp_id")
	private Sp sp;

	@Column(name="email")
	private String email;
	
	@Column(name="hire_date")
	private Date hireDate;
	
	@Column(name="terminated_flag")
	private String terminatedFlag;
	
	@Column(name="job_id")
	private Integer jobId;

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

	public Sp getSp() {
		return sp;
	}

	public void setSp(Sp sp) {
		this.sp = sp;
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

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public SpMember() {
		
	}

	public SpMember(String fullNameAr, String fullNameEn, Sp sp, String email, Date hireDate, String terminatedFlag,
			Integer jobId) {
		super();
		this.fullNameAr = fullNameAr;
		this.fullNameEn = fullNameEn;
		this.sp = sp;
		this.email = email;
		this.hireDate = hireDate;
		this.terminatedFlag = terminatedFlag;
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "SpMember [id=" + id + ", fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn + ", sp=" + sp
				+ ", email=" + email + ", hireDate=" + hireDate + ", terminatedFlag=" + terminatedFlag + ", jobId="
				+ jobId + "]";
	}
	
	
	
	
}
