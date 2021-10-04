package net.driver.pickupsa.app.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="sl_team")
@NamedQuery(name = "findTeamByManagerId", query = "SELECT e from Team e WHERE e.spMember.id=?1")
public class Team implements Serializable{


	private static final long serialVersionUID = 6336345784226299958L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "active_flag")
	private String activeFlag;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	private SpMember spMember;
	
	@ManyToOne
	@JoinColumn(name="sp_id")
	private Sp sp;
	
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public SpMember getSpMember() {
		return spMember;
	}

	public void setSpMember(SpMember spMember) {
		this.spMember = spMember;
	}

	public Sp getSp() {
		return sp;
	}

	public void setSp(Sp sp) {
		this.sp = sp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", activeFlag=" + activeFlag + ", spMember=" + spMember + ", sp=" + sp
				+ ", vehicle=" + vehicle + "]";
	}
	
	
	
	

}
