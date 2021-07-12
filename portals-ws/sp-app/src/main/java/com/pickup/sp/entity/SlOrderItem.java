package com.pickup.sp.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pickup.sp.entity.shared.GnItem;
import com.pickup.sp.entity.shared.GnService;
import com.pickup.sp.entity.shared.WhoColumn;

@Entity()
@Table(name="sl_order_item")
public class SlOrderItem implements Serializable{
	private static final long serialVersionUID = 8872789565535084625L;
	
	public SlOrderItem() {}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="order_id")
	private SlOrder slOrder;
	
	@ManyToOne()
	@JoinColumn(name="service_id")
	private GnService gnService;
	
	@ManyToOne()
	@JoinColumn(name="item_id")
	private GnItem gnItem;
	
	@Column(name="qty")
	private Integer qty;
	
	@Column(name="unit_price")
	private Integer unitPrice;
	
	@Column(name="avg_cost")
	private BigDecimal avgCost;
	
	@Column(name="discount")
	private BigDecimal discount;
	@Embedded
	private WhoColumn whoColumn;
	@Override
	public String toString() {
		return "SlOrderItem [id=" + id + ", slOrder=" + slOrder + ", gnService=" + gnService + ", gnItem=" + gnItem
				+ ", qty=" + qty + ", unitPrice=" + unitPrice + ", avgCost=" + avgCost + ", discount=" + discount
				+ ", whoColumn=" + whoColumn + "]";
	}
	public SlOrderItem(SlOrder slOrder, GnService gnService, GnItem gnItem, Integer qty, Integer unitPrice,
			BigDecimal avgCost, BigDecimal discount, WhoColumn whoColumn) {
		super();
		this.slOrder = slOrder;
		this.gnService = gnService;
		this.gnItem = gnItem;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.avgCost = avgCost;
		this.discount = discount;
		this.whoColumn = whoColumn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SlOrder getSlOrder() {
		return slOrder;
	}
	public void setSlOrder(SlOrder slOrder) {
		this.slOrder = slOrder;
	}
	public GnService getGnService() {
		return gnService;
	}
	public void setGnService(GnService gnService) {
		this.gnService = gnService;
	}
	public GnItem getGnItem() {
		return gnItem;
	}
	public void setGnItem(GnItem gnItem) {
		this.gnItem = gnItem;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getAvgCost() {
		return avgCost;
	}
	public void setAvgCost(BigDecimal avgCost) {
		this.avgCost = avgCost;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public WhoColumn getWhoColumn() {
		return whoColumn;
	}
	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	
}
