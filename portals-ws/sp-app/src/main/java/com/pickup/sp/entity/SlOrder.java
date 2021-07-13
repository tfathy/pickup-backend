package com.pickup.sp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pickup.sp.entity.shared.GnCustomer;
import com.pickup.sp.entity.shared.GnLocationType;
import com.pickup.sp.entity.shared.GnVehicleSize;
import com.pickup.sp.entity.shared.WhoColumn;

@Entity()
@Table(name="sl_order")
public class SlOrder implements Serializable{
	private static final long serialVersionUID = -6974371190349853351L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<SlOrderItem> slOrderItem;
	
	@ManyToOne()
	@JoinColumn(name="customer_id")
	private GnCustomer gnCustomer;
	
	@ManyToOne()
	@JoinColumn(name="source_location_type_id")
	private GnLocationType sourceLocationType;
	
	@ManyToOne()
	@JoinColumn(name="dest_location_type_id")
	private GnLocationType destLocationType;
	
	@ManyToOne()
	@JoinColumn(name="vehicle_size_id")
	private GnVehicleSize gnVehicleSize;
	
	@ManyToOne()
	@JoinColumn(name="team_id")
	private SlTeam slTeam;
	
	@Column(name="request_date")
	private Date requestDate;
	
	@Column(name="reservation_date")
	private Date reservationDate;
	
	@Column(name="ord_exec_date")
	private Date ordExecDate;
	
	/*
	 * 
	 * valid values are:\nREQUEST\nCANCELED_BY_CUSTOMER\nCANCELED_BY_TEAM\nRECEIVED_BY_TEAM\nCALLED_CUSTOMER\nTEAM_ON_THE_WAY\nTEAM_ARRIVED\nPAYMENT_SUCCESS\nPAYMENT_FAILD\n
	 */
	@Column(name="ord_status")
	private String ordStatus;
	
	@Column(name="source_elv_flag")
	private String sourceElvFlag;
	
	@Column(name="source_floor_num")
	private Integer sourceFloorNum;
	
	@Column(name="source_long")
	private Integer sourceLong;
	
	@Column(name="source_lat")
	private Integer sourceLat;
	
	@Column(name="source_formatted_address")
	private String sourceFormattedAddress;
	
	@Column(name="dest_elv_flag")
	private String destElvFlag;
	
	@Column(name="dest_floor_num")
	private Integer destFloorNum;
	
	@Column(name="dest_formated_address")
	private String destFormatedAddress;
	
	@Column(name="dest_long")
	private Integer destLong;
	
	@Column(name="dest_lat")
	private Integer destLat;
	
	@Column(name="estimate_cost")
	private BigDecimal estimateCost;
	
	@Column(name="actual_cost")
	private BigDecimal actualCost;
	
	@Column(name="customer_notes")
	private String customerNotes;
	
	@Column(name="team_notes")
	private String teamNotes;
	
	@Embedded
	private WhoColumn whoColumn;
	
	public SlOrder() {}

	

	
	public SlOrder(List<SlOrderItem> slOrderItem, GnCustomer gnCustomer, GnLocationType sourceLocationType,
			GnLocationType destLocationType, GnVehicleSize gnVehicleSize, SlTeam slTeam, Date requestDate,
			Date reservationDate, Date ordExecDate, String ordStatus, String sourceElvFlag, Integer sourceFloorNum,
			Integer sourceLong, Integer sourceLat, String sourceFormattedAddress, String destElvFlag,
			Integer destFloorNum, String destFormatedAddress, Integer destLong, Integer destLat,
			BigDecimal estimateCost, BigDecimal actualCost, String customerNotes, String teamNotes,
			WhoColumn whoColumn) {
		super();
		this.slOrderItem = slOrderItem;
		this.gnCustomer = gnCustomer;
		this.sourceLocationType = sourceLocationType;
		this.destLocationType = destLocationType;
		this.gnVehicleSize = gnVehicleSize;
		this.slTeam = slTeam;
		this.requestDate = requestDate;
		this.reservationDate = reservationDate;
		this.ordExecDate = ordExecDate;
		this.ordStatus = ordStatus;
		this.sourceElvFlag = sourceElvFlag;
		this.sourceFloorNum = sourceFloorNum;
		this.sourceLong = sourceLong;
		this.sourceLat = sourceLat;
		this.sourceFormattedAddress = sourceFormattedAddress;
		this.destElvFlag = destElvFlag;
		this.destFloorNum = destFloorNum;
		this.destFormatedAddress = destFormatedAddress;
		this.destLong = destLong;
		this.destLat = destLat;
		this.estimateCost = estimateCost;
		this.actualCost = actualCost;
		this.customerNotes = customerNotes;
		this.teamNotes = teamNotes;
		this.whoColumn = whoColumn;
	}




	@Override
	public String toString() {
		return "SlOrder [id=" + id + ", slOrderItem=" + slOrderItem + ", gnCustomer=" + gnCustomer
				+ ", sourceLocationType=" + sourceLocationType + ", destLocationType=" + destLocationType
				+ ", gnVehicleSize=" + gnVehicleSize + ", slTeam=" + slTeam + ", requestDate=" + requestDate
				+ ", reservationDate=" + reservationDate + ", ordExecDate=" + ordExecDate + ", ordStatus=" + ordStatus
				+ ", sourceElvFlag=" + sourceElvFlag + ", sourceFloorNum=" + sourceFloorNum + ", sourceLong="
				+ sourceLong + ", sourceLat=" + sourceLat + ", sourceFormattedAddress=" + sourceFormattedAddress
				+ ", destElvFlag=" + destElvFlag + ", destFloorNum=" + destFloorNum + ", destFormatedAddress="
				+ destFormatedAddress + ", destLong=" + destLong + ", destLat=" + destLat + ", estimateCost="
				+ estimateCost + ", actualCost=" + actualCost + ", customerNotes=" + customerNotes + ", teamNotes="
				+ teamNotes + ", whoColumn=" + whoColumn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GnCustomer getGnCustomer() {
		return gnCustomer;
	}

	public void setGnCustomer(GnCustomer gnCustomer) {
		this.gnCustomer = gnCustomer;
	}

	public GnLocationType getSourceLocationType() {
		return sourceLocationType;
	}

	public void setSourceLocationType(GnLocationType sourceLocationType) {
		this.sourceLocationType = sourceLocationType;
	}

	public GnLocationType getDestLocationType() {
		return destLocationType;
	}

	public void setDestLocationType(GnLocationType destLocationType) {
		this.destLocationType = destLocationType;
	}

	public GnVehicleSize getGnVehicleSize() {
		return gnVehicleSize;
	}

	public void setGnVehicleSize(GnVehicleSize gnVehicleSize) {
		this.gnVehicleSize = gnVehicleSize;
	}

	public SlTeam getSlTeam() {
		return slTeam;
	}

	public void setSlTeam(SlTeam slTeam) {
		this.slTeam = slTeam;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getOrdExecDate() {
		return ordExecDate;
	}

	public void setOrdExecDate(Date ordExecDate) {
		this.ordExecDate = ordExecDate;
	}

	public String getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}

	public String getSourceElvFlag() {
		return sourceElvFlag;
	}

	public void setSourceElvFlag(String sourceElvFlag) {
		this.sourceElvFlag = sourceElvFlag;
	}

	public Integer getSourceFloorNum() {
		return sourceFloorNum;
	}

	public void setSourceFloorNum(Integer sourceFloorNum) {
		this.sourceFloorNum = sourceFloorNum;
	}

	public Integer getSourceLong() {
		return sourceLong;
	}

	public void setSourceLong(Integer sourceLong) {
		this.sourceLong = sourceLong;
	}

	public Integer getSourceLat() {
		return sourceLat;
	}

	public void setSourceLat(Integer sourceLat) {
		this.sourceLat = sourceLat;
	}

	public String getSourceFormattedAddress() {
		return sourceFormattedAddress;
	}

	public void setSourceFormattedAddress(String sourceFormattedAddress) {
		this.sourceFormattedAddress = sourceFormattedAddress;
	}

	public String getDestElvFlag() {
		return destElvFlag;
	}

	public void setDestElvFlag(String destElvFlag) {
		this.destElvFlag = destElvFlag;
	}

	public Integer getDestFloorNum() {
		return destFloorNum;
	}

	public void setDestFloorNum(Integer destFloorNum) {
		this.destFloorNum = destFloorNum;
	}

	public String getDestFormatedAddress() {
		return destFormatedAddress;
	}

	public void setDestFormatedAddress(String destFormatedAddress) {
		this.destFormatedAddress = destFormatedAddress;
	}

	public Integer getDestLong() {
		return destLong;
	}

	public void setDestLong(Integer destLong) {
		this.destLong = destLong;
	}

	public Integer getDestLat() {
		return destLat;
	}

	public void setDestLat(Integer destLat) {
		this.destLat = destLat;
	}

	public BigDecimal getEstimateCost() {
		return estimateCost;
	}

	public void setEstimateCost(BigDecimal estimateCost) {
		this.estimateCost = estimateCost;
	}

	public BigDecimal getActualCost() {
		return actualCost;
	}

	public void setActualCost(BigDecimal actualCost) {
		this.actualCost = actualCost;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getTeamNotes() {
		return teamNotes;
	}

	public void setTeamNotes(String teamNotes) {
		this.teamNotes = teamNotes;
	}

	public WhoColumn getWhoColumn() {
		return whoColumn;
	}

	public void setWhoColumn(WhoColumn whoColumn) {
		this.whoColumn = whoColumn;
	}

	public List<SlOrderItem> getSlOrderItem() {
		return slOrderItem;
	}

	public void setSlOrderItem(List<SlOrderItem> slOrderItem) {
		this.slOrderItem = slOrderItem;
	}
	
	
	
}
