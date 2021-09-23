package net.driver.pickupsa.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.driver.pickupsa.security.entity.lookup.Sp;
import net.driver.pickupsa.security.entity.lookup.SpMember;

@Entity
@Table(name = "sys_user")
@ApiModel(value = "This object stores users account details for drivers It is based on sys-user table with only attributes related to driver")
public class DriverUser implements Serializable {

	private static final long serialVersionUID = -6961239631068751016L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ApiModelProperty(value = "This is system generated random string.It is used for composing jwt.We use it instead of Id column because the ID column is a sensitive information.")
	@Column(name = "user_id")
	private String userId;
	
	
	@Column(name = "email")
	private String email;
	
	@ApiModelProperty(value = "This an ecrypted")
	@Column(name = "user_password")
	private String encryptedPassword;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "account_status")
	private String accountStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sp_id")
	private Sp sp;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="member_id")
	private SpMember member;
	
	@Column(name="fcm_token")
	private String fcmToken;
	
	public DriverUser() {
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
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



	public Sp getSp() {
		return sp;
	}



	public void setSp(Sp sp) {
		this.sp = sp;
	}



	public SpMember getMember() {
		return member;
	}



	public String getFcmToken() {
		return fcmToken;
	}



	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}



	public void setMember(SpMember member) {
		this.member = member;
	}



	@Override
	public String toString() {
		return "DriverUser [Id=" + Id + ", userId=" + userId + ", email=" + email + ", encryptedPassword="
				+ encryptedPassword + ", userType=" + userType + ", accountStatus=" + accountStatus + ", sp=" + sp
				+ ", member=" + member + ", fcmToken=" + fcmToken + "]";
	}



	public DriverUser(String userId, String email, String encryptedPassword, String userType, String accountStatus,
			Sp sp, SpMember member, String fcmToken) {
		super();
		this.userId = userId;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.userType = userType;
		this.accountStatus = accountStatus;
		this.sp = sp;
		this.member = member;
		this.fcmToken = fcmToken;
	}



	
	
}
