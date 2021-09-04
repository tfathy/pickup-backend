package net.driver.pickupsa.security.model;

import java.io.Serializable;

import net.driver.pickupsa.security.entity.lookup.Sp;
import net.driver.pickupsa.security.entity.lookup.SpMember;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -5306741567424897634L;

	private Sp sp;
	private SpMember member;
	private String userId;
	private String email;
	private String password;
	private String encryptedPassword;
	private String userType;
	private String accountStatus;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "UserDto [sp=" + sp + ", member=" + member + ", userId=" + userId + ", email=" + email + ", password="
				+ password + ", encryptedPassword=" + encryptedPassword + ", userType=" + userType + ", accountStatus="
				+ accountStatus + "]";
	}

	public UserDto(Sp sp, SpMember member, String userId, String email, String password, String encryptedPassword,
			String userType, String accountStatus) {
		super();
		this.sp = sp;
		this.member = member;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.encryptedPassword = encryptedPassword;
		this.userType = userType;
		this.accountStatus = accountStatus;
	}

	public UserDto() {
	}
}
