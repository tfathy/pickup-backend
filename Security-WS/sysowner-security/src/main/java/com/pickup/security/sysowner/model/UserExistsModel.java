package com.pickup.security.sysowner.model;

import java.io.Serializable;

public class UserExistsModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5055530649010784751L;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public UserExistsModel() {
	}

	public UserExistsModel(String email) {
		this.email = email;
	}
	
	
}
