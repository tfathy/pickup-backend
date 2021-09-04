package net.driver.pickupsa.app.entity.lookup;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sp_service_provider")
public class Sp implements Serializable{

	private static final long serialVersionUID = -7222181575029965199L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="account_status")
	private String accountStatus;
	
	@Column(name="order_vat_prcnt")
	private BigDecimal orderVatPrcnt;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BigDecimal getOrderVatPrcnt() {
		return orderVatPrcnt;
	}

	public void setOrderVatPrcnt(BigDecimal orderVatPrcnt) {
		this.orderVatPrcnt = orderVatPrcnt;
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
	
	
}
