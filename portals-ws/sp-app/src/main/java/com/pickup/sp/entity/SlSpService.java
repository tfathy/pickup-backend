package com.pickup.sp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name="sl_sp_service")
public class SlSpService implements Serializable{

	private static final long serialVersionUID = -555361588122936376L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="sp_id")
	private SpServiceProvider sp; 
	
	
	@Column(name="item_service_id")
	private Integer itemServiceId;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Column(name = "notes")
	private String notes;

	@Embedded
	private WhoColumn whoColumn;

	public SlSpService() {}
	public SlSpService(SpServiceProvider sp, Integer itemServiceId, String activeFlag, String notes,
			WhoColumn whoColumn) {
		super();
		this.sp = sp;
		this.itemServiceId = itemServiceId;
		this.activeFlag = activeFlag;
		this.notes = notes;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SlSpService [id=" + id + ", sp=" + sp + ", itemServiceId=" + itemServiceId + ", activeFlag="
				+ activeFlag + ", notes=" + notes + ", whoColumn=" + whoColumn + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SpServiceProvider getSp() {
		return sp;
	}
	public void setSp(SpServiceProvider sp) {
		this.sp = sp;
	}
	public Integer getItemServiceId() {
		return itemServiceId;
	}
	public void setItemServiceId(Integer itemServiceId) {
		this.itemServiceId = itemServiceId;
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
	public WhoColumn getWhoColumn() {
		return whoColumn;
	}
	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	
	

}
