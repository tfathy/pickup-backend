package com.customer.pickup.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sl_order_images")
public class OrderImages implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5794312283390869482L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="ord_id")
	private Integer ordId;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_ext")
	private String imageExt;
	
	@Column(name="image_size")
	private Integer imageSize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageExt() {
		return imageExt;
	}

	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}

	public Integer getImageSize() {
		return imageSize;
	}

	@Override
	public String toString() {
		return "OrderImages [id=" + id + ", ordId=" + ordId + ", imageName=" + imageName + ", imageExt=" + imageExt
				+ ", imageSize=" + imageSize + "]";
	}

	public void setImageSize(Integer imageSize) {
		this.imageSize = imageSize;
	}
	
	
}
