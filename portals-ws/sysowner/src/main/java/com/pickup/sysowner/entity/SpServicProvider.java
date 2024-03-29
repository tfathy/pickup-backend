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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name = "sp_service_provider")
public class SpServicProvider implements Serializable {

	private static final long serialVersionUID = 6214302219631495812L;

	public SpServicProvider() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private SysOwner sysOwner;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_request_id")
	private SysSubscriptionRequest subscribtionRequest;

	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "account_status")
	private String accountStatus;

	@Column(name = "order_vat_prcnt")
	private Double orderVatPrcnt;
	@Column(name="country_id")
	private Integer countryId;
	
	@Column(name="company_name_ar")
	private String companyNameAr;
	
	@Column(name="company_name_en")
	private String companyNameEn;
	
	@Column(name="contact_person_name_ar")
	private String contactPersonNameAr;
	
	@Column(name="contact_person_name_en")
	private String contactPersonNameEn;
	
	@Column(name="contact_person_email")
	private String contactPersonEmail;
	
	@Column(name="comm_number")
	private String commNumber;
	
	@Column(name="address")
	private String address;

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

	public SysSubscriptionRequest getSubscribtionRequest() {
		return subscribtionRequest;
	}

	public void setSubscribtionRequest(SysSubscriptionRequest subscribtionRequest) {
		this.subscribtionRequest = subscribtionRequest;
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

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Double getOrderVatPrcnt() {
		return orderVatPrcnt;
	}

	public void setOrderVatPrcnt(Double orderVatPrcnt) {
		this.orderVatPrcnt = orderVatPrcnt;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
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

	public String getContactPersonNameAr() {
		return contactPersonNameAr;
	}

	public void setContactPersonNameAr(String contactPersonNameAr) {
		this.contactPersonNameAr = contactPersonNameAr;
	}

	public String getContactPersonNameEn() {
		return contactPersonNameEn;
	}

	public void setContactPersonNameEn(String contactPersonNameEn) {
		this.contactPersonNameEn = contactPersonNameEn;
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

	public SpServicProvider(SysOwner sysOwner, SysSubscriptionRequest subscribtionRequest, String descAr, String descEn,
			String accountStatus, Double orderVatPrcnt, Integer countryId, String companyNameAr, String companyNameEn,
			String contactPersonNameAr, String contactPersonNameEn, String contactPersonEmail, String commNumber,
			String address, WhoColumn whoColumn) {
		super();
		this.sysOwner = sysOwner;
		this.subscribtionRequest = subscribtionRequest;
		this.descAr = descAr;
		this.descEn = descEn;
		this.accountStatus = accountStatus;
		this.orderVatPrcnt = orderVatPrcnt;
		this.countryId = countryId;
		this.companyNameAr = companyNameAr;
		this.companyNameEn = companyNameEn;
		this.contactPersonNameAr = contactPersonNameAr;
		this.contactPersonNameEn = contactPersonNameEn;
		this.contactPersonEmail = contactPersonEmail;
		this.commNumber = commNumber;
		this.address = address;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SpServicProvider [id=" + id + ", sysOwner=" + sysOwner + ", subscribtionRequest=" + subscribtionRequest
				+ ", descAr=" + descAr + ", descEn=" + descEn + ", accountStatus=" + accountStatus + ", orderVatPrcnt="
				+ orderVatPrcnt + ", countryId=" + countryId + ", companyNameAr=" + companyNameAr + ", companyNameEn="
				+ companyNameEn + ", contactPersonNameAr=" + contactPersonNameAr + ", contactPersonNameEn="
				+ contactPersonNameEn + ", contactPersonEmail=" + contactPersonEmail + ", commNumber=" + commNumber
				+ ", address=" + address + ", whoColumn=" + whoColumn + "]";
	}


}
