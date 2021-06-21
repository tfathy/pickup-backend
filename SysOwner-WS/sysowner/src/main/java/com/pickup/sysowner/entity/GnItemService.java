package com.pickup.sysowner.entity;

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
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name="gn_item_service")
public class GnItemService implements Serializable{

	private static final long serialVersionUID = -6560007795285325367L;
	public GnItemService() {
		
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private GnItem gnItem;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="service_id")
	private GnService gnService;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GnItem getGnItem() {
		return gnItem;
	}

	public void setGnItem(GnItem gnItem) {
		this.gnItem = gnItem;
	}

	public GnService getGnService() {
		return gnService;
	}

	public void setGnService(GnService gnService) {
		this.gnService = gnService;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "GnItemService [id=" + id + ", gnItem=" + gnItem + ", gnService=" + gnService + ", activeFlag="
				+ activeFlag + ", whoColumn=" + whoColumn + "]";
	}

	public GnItemService(GnItem gnItem, GnService gnService, String activeFlag, WhoColumn whoColumn) {
		super();
		this.gnItem = gnItem;
		this.gnService = gnService;
		this.activeFlag = activeFlag;
		this.whoColumn = whoColumn;
	}
	
	
	
}
