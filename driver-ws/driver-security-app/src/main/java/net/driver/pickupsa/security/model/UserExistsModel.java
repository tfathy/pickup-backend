package net.driver.pickupsa.security.model;

import java.io.Serializable;

public class UserExistsModel implements Serializable{

	private static final long serialVersionUID = 825152445180449330L;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserExistsModel(String email) {
		this.email = email;
	}

	public UserExistsModel() {
	}
	

}
