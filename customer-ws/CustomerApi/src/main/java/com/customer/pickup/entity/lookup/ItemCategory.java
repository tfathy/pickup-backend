package com.customer.pickup.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="gn_item_category")
public class ItemCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1310281430481886101L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="desc_en")
	private String descEn;
	@Column(name="desc_ar")
	private String descAr;
	@Column(name="active_flag")
	private String activeFlag;
	public ItemCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemCategory(String descEn, String descAr, String activeFlag) {
		super();
		this.descEn = descEn;
		this.descAr = descAr;
		this.activeFlag = activeFlag;
	}
	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", descEn=" + descEn + ", descAr=" + descAr + ", activeFlag=" + activeFlag
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	

}
