package com.pickup.security.sysowner.entity.shared;

import java.io.Serializable;

import com.pickup.security.sysowner.entity.lookup.HrEmployee;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 5578450681161774767L;
	
	private HrEmployee hrEmployee;
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
	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	@Override
	public String toString() {
		return "UserDto [hrEmployee=" + hrEmployee + ", userId=" + userId + ", email=" + email + ", encryptedPassword="
				+ encryptedPassword + ", userType=" + userType + ", accountStatus=" + accountStatus + ", whoColumn="
				+ whoColumn + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
