package net.driver.pickupsa.app.service;


import java.util.List;

import net.driver.pickupsa.app.entity.UserLogin;

public interface UserLoginService {
	
	UserLogin create(UserLogin entity);
	UserLogin update (UserLogin entity, Integer id);
	List<UserLogin> findAvailabe(Integer vclSizeId);
	

}
