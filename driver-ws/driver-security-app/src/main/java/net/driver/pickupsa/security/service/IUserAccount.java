package net.driver.pickupsa.security.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import net.driver.pickupsa.security.entity.DriverUser;
import net.driver.pickupsa.security.model.UserDto;
import net.driver.pickupsa.security.model.UserExistsModel;

public interface IUserAccount extends UserDetailsService{

	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
	public DriverUser update(DriverUser driverUser,String userId);
	public DriverUser changePassword(String email,String oldpassword,String newpassword);
	public UserExistsModel RestPassword(String email);
	public DriverUser findByUserId(String userid);
	public DriverUser findByEmail(String email);
}
