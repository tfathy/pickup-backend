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

import com.pickup.sp.entity.shared.SysOwner;
import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name="sp_service_provider")
public class SpServiceProvider implements Serializable{

	private static final long serialVersionUID = 541863321627294701L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "owner_id")
	private SysOwner sysOwner;
	
	@ManyToOne()
	@JoinColumn(name = "subscription_request_id")
	private SysSubscriptionRequest sysSubscriptionRequest;
	
	
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="account_status")
	private String accountStatus;
	
	@Column(name="order_vat_prcnt")
	private Integer orderVatPrcnt;
	
	@Embedded
	private WhoColumn whoColumn;
	
	public SpServiceProvider() {
		
	}

	public SpServiceProvider(SysOwner sysOwner, SysSubscriptionRequest sysSubscriptionRequest, String descAr,
			String descEn, String accountStatus, Integer orderVatPrcnt, WhoColumn whoColumn) {
		super();
		this.sysOwner = sysOwner;
		this.sysSubscriptionRequest = sysSubscriptionRequest;
		this.descAr = descAr;
		this.descEn = descEn;
		this.accountStatus = accountStatus;
		this.orderVatPrcnt = orderVatPrcnt;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SpServiceProvider [id=" + id + ", sysOwner=" + sysOwner + ", sysSubscriptionRequest="
				+ sysSubscriptionRequest + ", descAr=" + descAr + ", descEn=" + descEn + ", accountStatus="
				+ accountStatus + ", orderVatPrcnt=" + orderVatPrcnt + ", whoColumn=" + whoColumn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SysOwner getSysOwner() {
		return sysOwner;
	}

	public void setSysOwner(SysOwner sysOwner) {
		this.sysOwner = sysOwner;
	}

	public SysSubscriptionRequest getSysSubscriptionRequest() {
		return sysSubscriptionRequest;
	}

	public void setSysSubscriptionRequest(SysSubscriptionRequest sysSubscriptionRequest) {
		this.sysSubscriptionRequest = sysSubscriptionRequest;
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

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getOrderVatPrcnt() {
		return orderVatPrcnt;
	}

	public void setOrderVatPrcnt(Integer orderVatPrcnt) {
		this.orderVatPrcnt = orderVatPrcnt;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}
	

}
