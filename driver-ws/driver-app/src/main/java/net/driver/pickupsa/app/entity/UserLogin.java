package net.driver.pickupsa.app.entity;

import java.io.Serializable;
import java.util.Date;

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
import net.driver.pickupsa.app.entity.lookup.SysUser;

@Entity
@Table(name="sys_user_login")
public class UserLogin implements Serializable{
	private static final long serialVersionUID = 6765162453533144542L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private SysUser sysUser;
	
	@Column(name="login_date")
	private Date loginDate;
	
	@Column(name="logout_date")
	private Date logoutDate;
	
	@Column(name="status")
	private String status;
	
	@ApiModelProperty(value = "GPS longitude location-last loation for the driver")
	@Column(name="longitude")
	private Integer longitude;
	
	@ApiModelProperty(value = "GPS latitude location-last loation for the driver")
	@Column(name="latitude")
	private Integer latitude;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "UserLogin [Id=" + Id + ", sysUser=" + sysUser + ", loginDate=" + loginDate + ", logoutDate="
				+ logoutDate + ", status=" + status + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(SysUser sysUser, Date loginDate, Date logoutDate, String status, Integer longitude,
			Integer latitude) {
		super();
		this.sysUser = sysUser;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
		this.status = status;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	

}
