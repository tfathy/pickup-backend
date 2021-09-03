package com.customer.pickup.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.customer.pickup.entity.lookup.LocationType;
import com.customer.pickup.entity.lookup.Team;
import com.customer.pickup.entity.lookup.VehicleSize;
import com.customer.pickup.entity.shared.WhoColumn;

@Entity()
@Table(name="sl_order")
@NamedQuery(name="findOrdByCustomerId", query="SELECT e FROM SlOrder e WHERE e.customer.id=?1")
@NamedQuery(name="findOrdByCustmerAndStatus", query="SELECT e FROM SlOrder e WHERE e.customer.id=?1 and e.ordStatus=?2")
public class SlOrder implements Serializable {

	private static final long serialVersionUID = 3217554080824009386L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne()
	@JoinColumn(name="source_location_type_id")
	private LocationType sourceLocationType;
	
	@ManyToOne()
	@JoinColumn(name="dest_location_type_id")
	private LocationType destLocationType;
	
	@ManyToOne()
	@JoinColumn(name="team_id")
	private Team team;
	
	@ManyToOne()
	@JoinColumn(name="vehicle_size_id")
	private VehicleSize vehicleSize;
	
	@Column(name="request_date")
	private Date requestDate;
		
	@Column(name="reservation_date")
	private Date reservationDate;
	
	@Column(name="ord_exec_date")
	private Date ordExecDate;
	
	@Column(name="ord_status")
	private String ordStatus;
	
	@Column(name="source_elv_flag")
	private String sourceElvFlag;
	
	@Column(name="source_floor_num")
	private Integer sourceFloorNum;
	
	@Column(name="source_long")
	private BigDecimal sourceLong;
	
	@Column(name="source_lat")
	private BigDecimal sourceLat;
	
	@Column(name="source_image_map")
	private String sourceImageMap;
	
	@Column(name="source_formatted_address")
	private String sourceFormattedAddress;
	
	@Column(name="dest_elv_flag")
	private String destElvFlag;
	
	@Column(name="dest_floor_num")
	private String destFloorNum;
	
	@Column(name="dest_formated_address")
	private String destFormattedAddress;
	
	@Column(name="dest_long")
	private BigDecimal destLong;
	
	@Column(name="dest_lat")
	private BigDecimal destLat;
	
	@Column(name="dest_image_map")
	private String destImageMap;
	
	@Column(name="estimate_cost")
	private BigDecimal estimatedCost;
	
	@Column(name="actual_cost")
	private BigDecimal actualCost;
	
	@Column(name="customer_notes")
	private String customerNotes;
	
	@Column(name="team_notes")
	private String teamNotes;
	
	@Embedded
	private WhoColumn whoColumn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocationType getSourceLocationType() {
		return sourceLocationType;
	}

	public void setSourceLocationType(LocationType sourceLocationType) {
		this.sourceLocationType = sourceLocationType;
	}

	public LocationType getDestLocationType() {
		return destLocationType;
	}

	public void setDestLocationType(LocationType destLocationType) {
		this.destLocationType = destLocationType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	public void setVehicleSize(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
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

	public BigDecimal getSourceLong() {
		return sourceLong;
	}

	public void setSourceLong(BigDecimal sourceLong) {
		this.sourceLong = sourceLong;
	}

	public BigDecimal getSourceLat() {
		return sourceLat;
	}

	public void setSourceLat(BigDecimal sourceLat) {
		this.sourceLat = sourceLat;
	}

	public String getSourceImageMap() {
		return sourceImageMap;
	}

	public void setSourceImageMap(String sourceImageMap) {
		this.sourceImageMap = sourceImageMap;
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

	public String getDestFloorNum() {
		return destFloorNum;
	}

	public void setDestFloorNum(String destFloorNum) {
		this.destFloorNum = destFloorNum;
	}

	public String getDestFormattedAddress() {
		return destFormattedAddress;
	}

	public void setDestFormattedAddress(String destFormattedAddress) {
		this.destFormattedAddress = destFormattedAddress;
	}

	public BigDecimal getDestLong() {
		return destLong;
	}

	public void setDestLong(BigDecimal destLong) {
		this.destLong = destLong;
	}

	public BigDecimal getDestLat() {
		return destLat;
	}

	public void setDestLat(BigDecimal destLat) {
		this.destLat = destLat;
	}

	public String getDestImageMap() {
		return destImageMap;
	}

	public void setDestImageMap(String destImageMap) {
		this.destImageMap = destImageMap;
	}

	public BigDecimal getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(BigDecimal estimatedCost) {
		this.estimatedCost = estimatedCost;
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

	public SlOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SlOrder(Customer customer, LocationType sourceLocationType, LocationType destLocationType, Team team,
			VehicleSize vehicleSize, Date requestDate, Date reservationDate, Date ordExecDate, String ordStatus,
			String sourceElvFlag, Integer sourceFloorNum, BigDecimal sourceLong, BigDecimal sourceLat,
			String sourceImageMap, String sourceFormattedAddress, String destElvFlag, String destFloorNum,
			String destFormattedAddress, BigDecimal destLong, BigDecimal destLat, String destImageMap,
			BigDecimal estimatedCost, BigDecimal actualCost, String customerNotes, String teamNotes,
			WhoColumn whoColumn) {
		super();
		this.customer = customer;
		this.sourceLocationType = sourceLocationType;
		this.destLocationType = destLocationType;
		this.team = team;
		this.vehicleSize = vehicleSize;
		this.requestDate = requestDate;
		this.reservationDate = reservationDate;
		this.ordExecDate = ordExecDate;
		this.ordStatus = ordStatus;
		this.sourceElvFlag = sourceElvFlag;
		this.sourceFloorNum = sourceFloorNum;
		this.sourceLong = sourceLong;
		this.sourceLat = sourceLat;
		this.sourceImageMap = sourceImageMap;
		this.sourceFormattedAddress = sourceFormattedAddress;
		this.destElvFlag = destElvFlag;
		this.destFloorNum = destFloorNum;
		this.destFormattedAddress = destFormattedAddress;
		this.destLong = destLong;
		this.destLat = destLat;
		this.destImageMap = destImageMap;
		this.estimatedCost = estimatedCost;
		this.actualCost = actualCost;
		this.customerNotes = customerNotes;
		this.teamNotes = teamNotes;
		this.whoColumn = whoColumn;
	}

	@Override
	public String toString() {
		return "SlOrder [id=" + id + ", customer=" + customer + ", sourceLocationType=" + sourceLocationType
				+ ", destLocationType=" + destLocationType + ", team=" + team + ", vehicleSize=" + vehicleSize
				+ ", requestDate=" + requestDate + ", reservationDate=" + reservationDate + ", ordExecDate="
				+ ordExecDate + ", ordStatus=" + ordStatus + ", sourceElvFlag=" + sourceElvFlag + ", sourceFloorNum="
				+ sourceFloorNum + ", sourceLong=" + sourceLong + ", sourceLat=" + sourceLat + ", sourceImageMap="
				+ sourceImageMap + ", sourceFormattedAddress=" + sourceFormattedAddress + ", destElvFlag=" + destElvFlag
				+ ", destFloorNum=" + destFloorNum + ", destFormattedAddress=" + destFormattedAddress + ", destLong="
				+ destLong + ", destLat=" + destLat + ", destImageMap=" + destImageMap + ", estimatedCost="
				+ estimatedCost + ", actualCost=" + actualCost + ", customerNotes=" + customerNotes + ", teamNotes="
				+ teamNotes + ", whoColumn=" + whoColumn + "]";
	}
	
	
	
	
	

}
