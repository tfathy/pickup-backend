package com.pickup.security.sysowner.entity.shared;

import java.io.Serializable;


import com.pickup.security.sysowner.entity.lookup.HrEmployee;
import com.pickup.security.sysowner.entity.lookup.Sp;
import com.pickup.security.sysowner.entity.lookup.SpMember;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 5578450681161774767L;
	
	private HrEmployee hrEmployee;
	private Sp sp;
	private SpMember member;
	private String userId;
	private String email;
	private String password;
	private String encryptedPassword;
	private String userType;
	private String accountStatus;	

	private WhoColumn whoColumn;
	
	
	
	public HrEmployee getHrEmployee() {
		return hrEmployee;
	}
	public void setHrEmployee(HrEmployee hrEmployee) {
		this.hrEmployee = hrEmployee;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
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
	public WhoColumn getWhoColumn() {
		return whoColumn;
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
	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	
	@Override
	public String toString() {
		return "UserDto [hrEmployee=" + hrEmployee + ", userId=" + userId + ", email=" + email + ", password="
				+ password + ", encryptedPassword=" + encryptedPassword + ", userType=" + userType + ", accountStatus="
				+ accountStatus + ", sp=" + sp + ", member=" + member + ", whoColumn=" + whoColumn + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(HrEmployee hrEmployee, Sp sp, SpMember member, String userId, String email, String password,
			String encryptedPassword, String userType, String accountStatus, WhoColumn whoColumn) {
		super();
		this.hrEmployee = hrEmployee;
		this.sp = sp;
		this.member = member;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.encryptedPassword = encryptedPassword;
		this.userType = userType;
		this.accountStatus = accountStatus;
		this.whoColumn = whoColumn;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
