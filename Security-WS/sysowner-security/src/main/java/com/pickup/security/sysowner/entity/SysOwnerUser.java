package com.pickup.security.sysowner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.pickup.security.sysowner.entity.lookup.HrEmployee;
import com.pickup.security.sysowner.entity.lookup.Sp;
import com.pickup.security.sysowner.entity.lookup.SpMember;
import com.pickup.security.sysowner.entity.shared.WhoColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity()
@Table(name = "sys_user")
@NamedQuery(name="QueryByUsernamePw",query=" Select e From SysOwnerUser e where e.email=?1 and e.encryptedPassword=?2")
@ApiModel(value = "This object stores data for System Owner user account- It is based on sys-user table with only attributes related to sys-owner")
public class SysOwnerUser implements Serializable {

	private static final long serialVersionUID = 3807881127090233723L;

	public SysOwnerUser() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private HrEmployee hrEmployee;
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
	
	@Embedded
	private WhoColumn whoColumn;

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	@Override
	public String toString() {
		return "SysOwnerUser [Id=" + Id + ", hrEmployee=" + hrEmployee + ", userId=" + userId + ", email=" + email
				+ ", encryptedPassword=" + encryptedPassword + ", userType=" + userType + ", accountStatus="
				+ accountStatus + ", whoColumn=" + whoColumn + "]";
	}

	public SysOwnerUser(HrEmployee hrEmployee, String userId, String email, String encryptedPassword, String userType,
			String accountStatus, WhoColumn whoColumn) {
		super();
		this.hrEmployee = hrEmployee;
		this.userId = userId;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.userType = userType;
		this.accountStatus = accountStatus;
		this.whoColumn = whoColumn;
	}

	
}
