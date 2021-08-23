package com.pickup.security.sysowner.model;

import com.pickup.security.sysowner.entity.lookup.Customer;
import com.pickup.security.sysowner.entity.lookup.HrEmployee;
import com.pickup.security.sysowner.entity.lookup.Sp;
import com.pickup.security.sysowner.entity.lookup.SpMember;
import com.pickup.security.sysowner.entity.shared.WhoColumn;

public class UserResponseModel {
	private String fullNameAr;
	private String fullNameEn;
	private String email;
	private String userId;
	private HrEmployee hrEmployee;
	private String userType;	
	private Sp sp;
	private SpMember member;	
	private Customer customer;
	private String accountStatus;
	private WhoColumn whoColumns;
	
	
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
	public HrEmployee getHrEmployee() {
		return hrEmployee;
	}
	public void setHrEmployee(HrEmployee hrEmployee) {
		this.hrEmployee = hrEmployee;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public WhoColumn getWhoColumns() {
		return whoColumns;
	}
	public void setWhoColumns(WhoColumn whoColumns) {
		this.whoColumns = whoColumns;
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
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "UserResponseModel [fullNameAr=" + fullNameAr + ", fullNameEn=" + fullNameEn + ", email=" + email
				+ ", userId=" + userId + ", hrEmployee=" + hrEmployee + ", userType=" + userType + ", sp=" + sp
				+ ", member=" + member + ", accountStatus=" + accountStatus + ", whoColumns=" + whoColumns + "]";
	}
	
	
	
	
}
