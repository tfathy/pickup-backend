package com.pickup.sysowner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name="sys_subscription_request")
public class SysSubscribtionRequest implements Serializable {

	private static final long serialVersionUID = -619721346466722043L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="owner_id")
	private SysOwner sysOwner;
	
	

}
