package net.driver.pickupsa.security.model;


import net.driver.pickupsa.security.entity.lookup.Sp;
import net.driver.pickupsa.security.entity.lookup.SpMember;

public class UserResponseModel {
	private String fullNameAr;
	private String fullNameEn;
	private String email;
	private String userId;
	private String userType;	
	private Sp sp;
	private SpMember member;
	
	private String accountStatus;
	private String fcmToken;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Sp getSp() {
		return sp;
	}
	public void setSp(Sp sp) {
		this.sp = sp;
	}
	public SpMember getMember() {
		return member;
	}
	public void setMember(SpMember member) {
		this.member = member;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	

	
	
}
