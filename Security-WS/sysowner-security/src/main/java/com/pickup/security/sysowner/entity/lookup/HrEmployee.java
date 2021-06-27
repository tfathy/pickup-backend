package com.pickup.security.sysowner.entity.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="hr_employee")
public class HrEmployee implements Serializable{

	private static final long serialVersionUID = 1635862290230292152L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "full_name_ar")
	private String fullNameAr;

	@Column(name = "full_name_en")
	private String fullNameEn;

	@Column(name = "notes")
	private String notes;


}
