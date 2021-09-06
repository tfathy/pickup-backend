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
import javax.persistence.Table;

@Entity
@Table(name = "gn_vehicle")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4669286256368440412L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "vehicle_size_id")
	private VehicleSize vehicleSize;
	
	@Column(name = "code")
	private String code;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "model_year")
	private Integer modelYear;

	@Column(name = "model_company")
	private String modelCompany;

	@Column(name = "licen_exp_date")
	private Date licenExpDate;

	@Column(name = "image_file_name")
	private String imageFileName;

	@Column(name = "active_flag")
	private String activeFlag;

	@Column(name = "notes")
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescEn() {
		return descEn;
	}

	public void setDescEn(String descEn) {
		this.descEn = descEn;
	}

	public String getDescAr() {
		return descAr;
	}

	public void setDescAr(String descAr) {
		this.descAr = descAr;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getModelCompany() {
		return modelCompany;
	}

	public void setModelCompany(String modelCompany) {
		this.modelCompany = modelCompany;
	}

	public Date getLicenExpDate() {
		return licenExpDate;
	}

	public void setLicenExpDate(Date licenExpDate) {
		this.licenExpDate = licenExpDate;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	public void setVehicleSize(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleSize=" + vehicleSize + ", code=" + code + ", descEn=" + descEn
				+ ", descAr=" + descAr + ", modelYear=" + modelYear + ", modelCompany=" + modelCompany
				+ ", licenExpDate=" + licenExpDate + ", imageFileName=" + imageFileName + ", activeFlag=" + activeFlag
				+ ", notes=" + notes + "]";
	}

	
	
	


}
