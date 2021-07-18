package com.pickup.sp.entity;

import java.io.Serializable;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pickup.sp.entity.shared.WhoColumn;

@Entity
@Table(name = "sl_team_member")
public class SlTeamMember implements Serializable {
	private static final long serialVersionUID = 8236488324563483694L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name = "team_id",nullable=false)
	@JsonIgnore
	private SlTeam slTeam;
	*/
	
	@Column(name="team_id",nullable = false)
	private Integer teamId;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private SpMember spMember;

	@Column(name = "notes")
	private String notes;

	@Embedded
	private WhoColumn whoColumn;

	public SlTeamMember() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SpMember getSpMember() {
		return spMember;
	}

	public void setSpMember(SpMember spMember) {
		this.spMember = spMember;
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


	public Integer getTeamId() {
		return teamId;
	}


	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}


	public SlTeamMember(Integer teamId, SpMember spMember, String notes, WhoColumn whoColumn) {
		super();
		this.teamId = teamId;
		this.spMember = spMember;
		this.notes = notes;
		this.whoColumn = whoColumn;
	}


	@Override
	public String toString() {
		return "SlTeamMember [id=" + id + ", teamId=" + teamId + ", spMember=" + spMember + ", notes=" + notes
				+ ", whoColumn=" + whoColumn + "]";
	}


	

	

}
