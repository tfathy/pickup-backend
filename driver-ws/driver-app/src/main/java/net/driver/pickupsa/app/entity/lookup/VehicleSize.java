package net.driver.pickupsa.app.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="gn_vehicle_size")
public class VehicleSize implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2971529060086607386L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "active_flag")
	private String activeFlag;

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

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "VehicleSize [id=" + id + ", descAr=" + descAr + ", descEn=" + descEn + ", activeFlag=" + activeFlag
				+ "]";
	}
	
	

}
