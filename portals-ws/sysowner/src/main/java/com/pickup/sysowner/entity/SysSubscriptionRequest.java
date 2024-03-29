package com.pickup.sysowner.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity()
@Table(name = "sys_subscription_request")
@ApiModel(description = "The Subscribtion request Object. The Service provider has to ,firstly, send a subscribtion request to subscribe for the service")
@NamedQuery(name="findNew", query="SELECT e FROM SysSubscriptionRequest e WHERE e.status in ('E','R')")
public class SysSubscriptionRequest implements Serializable {

	private static final long serialVersionUID = -619721346466722043L;

	public SysSubscriptionRequest() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "owner_id")
	private SysOwner sysOwner;

	@ManyToOne()
	@JoinColumn(name = "country_id")
	@ApiModelProperty(value = "Which Country does the subscriber's company belongs to.")
	
	private GnCountry gnCountry;
	@ApiModelProperty(value = "This is an auto-generated serial number.It is unique for each year.")
	@Column(name = "req_serial")
	private Integer reqSerial;

	@Column(name = "req_year")
	private Integer reqYear;

	@Column(name = "req_date")
	private Date reqDate;

	@Column(name = "requester_type")
	private String requesterType;

	@Column(name = "company_name_ar")
	private String companyNameAr;

	@Column(name = "company_name_en")
	private String companyNameEn;

	@Column(name = "contact_person_name")
	private String contactPersonName;

	@Column(name = "contact_person_phone")
	private String contactPersonPhone;

	@Column(name = "contact_person_email")
	private String contactPersonEmail;

	@Column(name = "comm_number")
	private String commNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "status")
	private String status;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="sub_request_id")
	private List<SysSubRequestAttachments> sysSubRequestAttachments;

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

	public GnCountry getGnCountry() {
		return gnCountry;
	}

	public void setGnCountry(GnCountry gnCountry) {
		this.gnCountry = gnCountry;
	}

	public Integer getReqSerial() {
		return reqSerial;
	}

	public void setReqSerial(Integer reqSerial) {
		this.reqSerial = reqSerial;
	}

	public Integer getReqYear() {
		return reqYear;
	}

	public void setReqYear(Integer reqYear) {
		this.reqYear = reqYear;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}

	public String getCompanyNameAr() {
		return companyNameAr;
	}

	public void setCompanyNameAr(String companyNameAr) {
		this.companyNameAr = companyNameAr;
	}

	public String getCompanyNameEn() {
		return companyNameEn;
	}

	public void setCompanyNameEn(String companyNameEn) {
		this.companyNameEn = companyNameEn;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getCommNumber() {
		return commNumber;
	}

	public void setCommNumber(String commNumber) {
		this.commNumber = commNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	

	public List<SysSubRequestAttachments> getSysSubRequestAttachments() {
		return sysSubRequestAttachments;
	}

	public void setSysSubRequestAttachments(List<SysSubRequestAttachments> sysSubRequestAttachments) {
		this.sysSubRequestAttachments = sysSubRequestAttachments;
	}

	
	@Override
	public String toString() {
		return "SysSubscriptionRequest [id=" + id + ", sysOwner=" + sysOwner + ", gnCountry=" + gnCountry
				+ ", reqSerial=" + reqSerial + ", reqYear=" + reqYear + ", reqDate=" + reqDate + ", requesterType="
				+ requesterType + ", companyNameAr=" + companyNameAr + ", companyNameEn=" + companyNameEn
				+ ", contactPersonName=" + contactPersonName + ", contactPersonPhone=" + contactPersonPhone
				+ ", contactPersonEmail=" + contactPersonEmail + ", commNumber=" + commNumber + ", address=" + address
				+ ", status=" + status + ", sysSubRequestAttachments=" + sysSubRequestAttachments + ", whoColumn="
				+ whoColumn + "]";
	}

}
