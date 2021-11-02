package net.driver.pickupsa.app.entity;

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
@Table(name="sys_order_location")
@NamedQuery(name="findOrdLocByOrderId",query="SELECT e FROM OrderLocation e WHERE e.slOrder.id=?1")
public class OrderLocation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="ord_id")
	private SlOrder slOrder;
	
	@Column(name="lng")
	private String lng;
	
	@Column(name="lat")
	private String lat;
	
	@Column(name="location_date")
	private Date locationDate;
	
	@Column(name="status")
	private String status;

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

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public Date getLocationDate() {
		return locationDate;
	}

	public void setLocationDate(Date locationDate) {
		this.locationDate = locationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderLocation [id=" + id + ", slOrder=" + slOrder + ", lng=" + lng + ", lat=" + lat + ", locationDate="
				+ locationDate + ", status=" + status + "]";
	}
	
	
	

}
