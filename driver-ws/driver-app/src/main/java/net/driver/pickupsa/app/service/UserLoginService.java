package net.driver.pickupsa.app.service;


import net.driver.pickupsa.app.entity.UserLogin;

public interface UserLoginService {
	
	UserLogin create(UserLogin entity);
	UserLogin update (UserLogin entity, Integer id);
	
	

}
