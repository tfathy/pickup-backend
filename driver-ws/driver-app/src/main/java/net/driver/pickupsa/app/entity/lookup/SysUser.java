package net.driver.pickupsa.app.entity.lookup;

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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = -8278855916296092585L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ApiModelProperty(value = "This is system generated random string.It is used for composing jwt.We use it instead of Id column because the ID column is a sensitive information.")
	@Column(name = "user_id")
	private String userId;
	@Column(name = "email")
	private String email;
	
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

	public void setMember(SpMember member) {
		this.member = member;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	
	
	

}
