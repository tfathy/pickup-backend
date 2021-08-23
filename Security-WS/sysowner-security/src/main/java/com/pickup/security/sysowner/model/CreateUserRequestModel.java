package com.pickup.security.sysowner.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pickup.security.sysowner.entity.lookup.Customer;
import com.pickup.security.sysowner.entity.lookup.HrEmployee;
import com.pickup.security.sysowner.entity.lookup.Sp;
import com.pickup.security.sysowner.entity.lookup.SpMember;
import com.pickup.security.sysowner.entity.shared.WhoColumn;

public class CreateUserRequestModel {
	@NotNull(message="password cannot be empty")
	@Size(min=4,message="passowrd cannot be less than 4 charachters")
	private String password;
	private String fullNameAr;
	private String fullNameEn;
	private String email;
	private String userId;
	private HrEmployee hrEmployee;
	private String userType;
	private String accountStatus;
	private Sp sp;
	private SpMember member;
	private Customer customer;
	private WhoColumn whoColumns;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "CreateUserRequestModel [password=" + password + ", fullNameAr=" + fullNameAr + ", fullNameEn="
				+ fullNameEn + ", email=" + email + ", userId=" + userId + ", hrEmployee=" + hrEmployee + ", userType="
				+ userType + ", accountStatus=" + accountStatus + ", sp=" + sp + ", member=" + member + ", customer="
				+ customer + ", whoColumns=" + whoColumns + "]";
	}

	
	
	
}
