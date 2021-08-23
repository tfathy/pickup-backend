package com.pickup.security.sysowner.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pickup.security.sysowner.entity.shared.WhoColumn;
@Entity
@Table(name="gn_customer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8982582125841411263L;
	
	@Id
	@Column(name="id")
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
	@Column(name="birth_date")
	private Date birthDate;
	@Column(name="email")
	private String email;
	@Column(name="home_city")
	private String homeCity;
	@Column(name="facebook_link")
	private String facebookLink;
	@Column(name="fb_photo_link")
	private String fbPhotoLink;
	@Column(name="fb_id")
	private String fbId;
	@Column(name="pay_card_type")
	private String payCardType;
	@Column(name="pay_card_number")
	private String payCardNumber;
	@Column(name="card_holder_name")
	private String cardHolderName;
	@Column(name="card_exp_date")
	private Date cardExpDate;
	@Embedded
	private WhoColumn whoColumn;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomeCity() {
		return homeCity;
	}
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getFbPhotoLink() {
		return fbPhotoLink;
	}
	public void setFbPhotoLink(String fbPhotoLink) {
		this.fbPhotoLink = fbPhotoLink;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getPayCardType() {
		return payCardType;
	}
	public void setPayCardType(String payCardType) {
		this.payCardType = payCardType;
	}
	public String getPayCardNumber() {
		return payCardNumber;
	}
	public void setPayCardNumber(String payCardNumber) {
		this.payCardNumber = payCardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Date getCardExpDate() {
		return cardExpDate;
	}
	public void setCardExpDate(Date cardExpDate) {
		this.cardExpDate = cardExpDate;
	}
	public WhoColumn getWhoColumn() {
		return whoColumn;
	}
	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", email=" + email + ", homeCity="
				+ homeCity + ", facebookLink=" + facebookLink + ", fbPhotoLink=" + fbPhotoLink + ", fbId=" + fbId
				+ ", payCardType=" + payCardType + ", payCardNumber=" + payCardNumber + ", cardHolderName="
				+ cardHolderName + ", cardExpDate=" + cardExpDate + ", whoColumn=" + whoColumn + "]";
	}
	
	

}
