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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import net.driver.pickupsa.app.entity.lookup.SysUser;


@Entity
@Table(name="sys_user_login")
@NamedQuery(name="availableDrivers",query="SELECT e FROM UserLogin e WHERE e.status='AVALIABLE' AND e.vclSizeId=?1")
public class UserLogin implements Serializable{

	public UserLogin() {		
	}
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
	private String longitude;
	
	@ApiModelProperty(value = "GPS latitude location-last loation for the driver")
	@Column(name="latitude")
	private String latitude;

	@Column(name="vcl_id")
	private Integer vclId;
	
	@Column(name="vcl_code")
	private String vclCode;
	
	@Column(name="vcl_desc_en")
	private String vclDescEn;
	
	@Column(name="vcl_size_id")
	private Integer vclSizeId;
	
	@Column(name="vcl_size_desc_en")
	private String vclSizeDescEn;
	
	@Column(name="vcl_size_desc_ar")
	private String vclSizeDescAr;
	
	@Column(name="team_desc_en")
	private String teamDescEn;
	
	@Column(name="team_id")
	private Integer teamId;
	
	@Column(name="driver_name_ar")
	private String driverNameAr;
	
	@Column(name="driver_name_en")
	private String driverNameEn;
	
	@Column(name="driver_id")
	private Integer driverId;
	
	@Column(name="sp_name_ar")
	private String spNameAr;
	
	@Column(name="sp_name_en")
	private String spNameEn;
	
	@Column(name="sp_id")
	private Integer spId;
	
	
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

	
	

	


	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getVclDescEn() {
		return vclDescEn;
	}

	public void setVclDescEn(String vclDescEn) {
		this.vclDescEn = vclDescEn;
	}

	public Integer getVclSizeId() {
		return vclSizeId;
	}

	public void setVclSizeId(Integer vclSizeId) {
		this.vclSizeId = vclSizeId;
	}

	public String getVclSizeDescEn() {
		return vclSizeDescEn;
	}

	public void setVclSizeDescEn(String vclSizeDescEn) {
		this.vclSizeDescEn = vclSizeDescEn;
	}

	public String getVclSizeDescAr() {
		return vclSizeDescAr;
	}

	public void setVclSizeDescAr(String vclSizeDescAr) {
		this.vclSizeDescAr = vclSizeDescAr;
	}

	public String getTeamDescEn() {
		return teamDescEn;
	}

	public void setTeamDescEn(String teamDescEn) {
		this.teamDescEn = teamDescEn;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getDriverNameAr() {
		return driverNameAr;
	}

	public void setDriverNameAr(String driverNameAr) {
		this.driverNameAr = driverNameAr;
	}

	public String getDriverNameEn() {
		return driverNameEn;
	}

	public void setDriverNameEn(String driverNameEn) {
		this.driverNameEn = driverNameEn;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getSpNameAr() {
		return spNameAr;
	}

	public void setSpNameAr(String spNameAr) {
		this.spNameAr = spNameAr;
	}

	public String getSpNameEn() {
		return spNameEn;
	}

	public void setSpNameEn(String spNameEn) {
		this.spNameEn = spNameEn;
	}

	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	public Integer getVclId() {
		return vclId;
	}

	public void setVclId(Integer vclId) {
		this.vclId = vclId;
	}

	public String getVclCode() {
		return vclCode;
	}

	public void setVclCode(String vclCode) {
		this.vclCode = vclCode;
	}	

	public UserLogin(SysUser sysUser, Date loginDate, Date logoutDate, String status, String longitude, String latitude,
			Integer vclId, String vclCode, String vclDescEn, Integer vclSizeId, String vclSizeDescEn,
			String vclSizeDescAr, String teamDescEn, Integer teamId, String driverNameAr, String driverNameEn,
			Integer driverId, String spNameAr, String spNameEn, Integer spId) {
		super();
		this.sysUser = sysUser;
		this.loginDate = loginDate;
		this.logoutDate = logoutDate;
		this.status = status;
		this.longitude = longitude;
		this.latitude = latitude;
		this.vclId = vclId;
		this.vclCode = vclCode;
		this.vclDescEn = vclDescEn;
		this.vclSizeId = vclSizeId;
		this.vclSizeDescEn = vclSizeDescEn;
		this.vclSizeDescAr = vclSizeDescAr;
		this.teamDescEn = teamDescEn;
		this.teamId = teamId;
		this.driverNameAr = driverNameAr;
		this.driverNameEn = driverNameEn;
		this.driverId = driverId;
		this.spNameAr = spNameAr;
		this.spNameEn = spNameEn;
		this.spId = spId;
	}

	@Override
	public String toString() {
		return "UserLogin [Id=" + Id + ", sysUser=" + sysUser + ", loginDate=" + loginDate + ", logoutDate="
				+ logoutDate + ", status=" + status + ", longitude=" + longitude + ", latitude=" + latitude + ", vclId="
				+ vclId + ", vclCode=" + vclCode + ", vclDescEn=" + vclDescEn + ", vclSizeId=" + vclSizeId
				+ ", vclSizeDescEn=" + vclSizeDescEn + ", vclSizeDescAr=" + vclSizeDescAr + ", teamDescEn=" + teamDescEn
				+ ", teamId=" + teamId + ", driverNameAr=" + driverNameAr + ", driverNameEn=" + driverNameEn
				+ ", driverId=" + driverId + ", spNameAr=" + spNameAr + ", spNameEn=" + spNameEn + ", spId=" + spId
				+ "]";
	}

	 

}
