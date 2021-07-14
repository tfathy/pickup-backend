package com.pickup.sp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name="sp_job")
@NamedQuery(name="findJobBySpId",query="SELECT e FROM SpJob e WHERE e.sp.id=?1")
public class SpJob implements Serializable{

	private static final long serialVersionUID = -4912415306937486907L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="sp_id")
	private SpServiceProvider sp;
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Embedded
	private WhoColumn whoColumn;
	
	public SpJob() {
		
	}

	public SpJob(String descAr, String descEn, String jobDescription, String activeFlag, WhoColumn whoColumn) {
		super();
		this.descAr = descAr;
		this.descEn = descEn;
		this.jobDescription = jobDescription;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SpJob [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", jobDescription=" + jobDescription
				+ ", activeFlag=" + activeFlag + ", whoColumn=" + whoColumn + "]";
	}

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

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
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
