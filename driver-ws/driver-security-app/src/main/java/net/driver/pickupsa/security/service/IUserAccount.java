package net.driver.pickupsa.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.driver.pickupsa.security.entity.DriverUser;
import net.driver.pickupsa.security.model.UserDto;
import net.driver.pickupsa.security.model.UserExistsModel;

public interface IUserAccount extends UserDetailsService{

	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
	public DriverUser changePassword(String email,String oldpassword,String newpassword);
	public UserExistsModel RestPassword(String email);
	
	
	
}
