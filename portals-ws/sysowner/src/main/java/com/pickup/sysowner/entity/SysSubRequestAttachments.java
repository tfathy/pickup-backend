package com.pickup.sysowner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
@Entity()
@Table(name = "sys_sub_req_attachments")
@ApiModel(description = "The attachments of the subscription request. ")
@NamedQuery(name="findByRequestId", query="SELECT e FROM SysSubRequestAttachments e WHERE e.subRequestId=?1")
public class SysSubRequestAttachments  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1880889607862131335L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="sub_request_id")
	private Integer subRequestId;
	
	@Column(name="attach_type")
	private String attachType;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="file_size")
	private Integer fileSize;
	
	@Column(name="notes")
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getSubRequestId() {
		return subRequestId;
	}

	public void setSubRequestId(Integer subRequestId) {
		this.subRequestId = subRequestId;
	}

	@Override
	public String toString() {
		return "SysSubRequestAttachments [id=" + id + ", subRequestId=" + subRequestId + ", attachType=" + attachType
				+ ", fileName=" + fileName + ", fileType=" + fileType + ", fileSize=" + fileSize + ", notes=" + notes
				+ "]";
	}

	

}
