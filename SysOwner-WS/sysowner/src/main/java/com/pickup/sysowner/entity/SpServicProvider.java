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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name = "sp_service_provider")
public class SpServicProvider implements Serializable {

	private static final long serialVersionUID = 6214302219631495812L;

	public SpServicProvider() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private SysOwner sysOwner;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_request_id")
	private SysSubscribtionRequest subscribtionRequest;

	@Column(name = "desc_ar")
	private String descAr;

	@Column(name = "desc_en")
	private String descEn;

	@Column(name = "account_status")
	private String accountStatus;

	@Column(name = "order_vat_prcnt")
	private Double orderVatPrcnt;

	@Embedded
	private WhoColumn whoColumn;

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

	public SysSubscribtionRequest getSubscribtionRequest() {
		return subscribtionRequest;
	}

	public void setSubscribtionRequest(SysSubscribtionRequest subscribtionRequest) {
		this.subscribtionRequest = subscribtionRequest;
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

	public Double getOrderVatPrcnt() {
		return orderVatPrcnt;
	}

	public void setOrderVatPrcnt(Double orderVatPrcnt) {
		this.orderVatPrcnt = orderVatPrcnt;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SpServicProvider [id=" + id + ", sysOwner=" + sysOwner + ", subscribtionRequest=" + subscribtionRequest
				+ ", descAr=" + descAr + ", descEn=" + descEn + ", accountStatus=" + accountStatus + ", orderVatPrcnt="
				+ orderVatPrcnt + ", whoColumn=" + whoColumn + "]";
	}

	public SpServicProvider(SysOwner sysOwner, SysSubscribtionRequest subscribtionRequest, String descAr, String descEn,
			String accountStatus, Double orderVatPrcnt, WhoColumn whoColumn) {
		super();
		this.sysOwner = sysOwner;
		this.subscribtionRequest = subscribtionRequest;
		this.descAr = descAr;
		this.descEn = descEn;
		this.accountStatus = accountStatus;
		this.orderVatPrcnt = orderVatPrcnt;
		this.whoColumn = whoColumn;
	}

}
