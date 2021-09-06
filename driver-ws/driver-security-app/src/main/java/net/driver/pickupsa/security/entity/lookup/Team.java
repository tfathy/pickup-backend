package net.driver.pickupsa.security.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sl_team")
//@NamedQuery(name = "findTeamByManagerId", query = "SELECT e from Team e WHERE e.manager.id=?1")
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3545704466660291158L;
	
	@Id
	@Column(name="id")	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name="manager_id")
	private SpMember spMember;
	
	@ManyToOne
	@JoinColumn(name = "sp_id")
	private Sp sp;

	@OneToOne()
	@JoinColumn(name = "vehicle_id")
	private Vehicle gnVehicle;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Sp getSp() {
		return sp;
	}

	public void setSp(Sp sp) {
		this.sp = sp;
	}

	public Vehicle getGnVehicle() {
		return gnVehicle;
	}

	public void setGnVehicle(Vehicle gnVehicle) {
		this.gnVehicle = gnVehicle;
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



}
