package com.pickup.sysowner.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pickup.sysowner.entity.shared.WhoColumn;

@Entity()
@Table(name="gn_item")
@NamedQuery(name="findByCatId",query="SELECT e FROM GnItem e WHERE e.gnItemCategory.id=?1 ")
public class GnItem implements Serializable{

	private static final long serialVersionUID = 5051926435662842176L;
	public GnItem() {
		
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	private GnItemCategory gnItemCategory;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="uom_id")
	private GnUom gnUom;
	
	@Column(name="item_code")
	private String itemCode;
	
	@Column(name="desc_en")
	private String descEn;
	
	@Column(name="desc_ar")
	private String descAr;
	
	@Column(name="active_flag")
	private String activeFlag;
	
	@OneToMany(cascade= CascadeType.ALL)	
	@JoinColumn(name="item_id")
	private List<GnItemService> gnItemService;
	
	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GnItemCategory getGnItemCategory() {
		return gnItemCategory;
	}

	public void setGnItemCategory(GnItemCategory gnItemCategory) {
		this.gnItemCategory = gnItemCategory;
	}

	public GnUom getGnuom() {
		return gnUom;
	}

	public void setGnuom(GnUom gnuom) {
		this.gnUom = gnuom;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	

	public GnItem(GnItemCategory gnItemCategory, GnUom gnUom, String itemCode, String descEn, String descAr,
			String activeFlag, List<GnItemService> gnItemService, WhoColumn whoColumn) {
		super();
		this.gnItemCategory = gnItemCategory;
		this.gnUom = gnUom;
		this.itemCode = itemCode;
		this.descEn = descEn;
		this.descAr = descAr;
		this.activeFlag = activeFlag;
		this.gnItemService = gnItemService;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "GnItem [id=" + id + ", gnItemCategory=" + gnItemCategory + ", gnUom=" + gnUom + ", itemCode=" + itemCode
				+ ", descEn=" + descEn + ", descAr=" + descAr + ", activeFlag=" + activeFlag + ", gnItemService="
				+ gnItemService + ", whoColumn=" + whoColumn + "]";
	}

	public GnUom getGnUom() {
		return gnUom;
	}

	public void setGnUom(GnUom gnUom) {
		this.gnUom = gnUom;
	}

	public List<GnItemService> getGnItemService() {
		return gnItemService;
	}

	public void setGnItemService(List<GnItemService> gnItemService) {
		this.gnItemService = gnItemService;
	}
	
	

}
