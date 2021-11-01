package net.driver.pickupsa.app.service;


import java.util.List;

import net.driver.pickupsa.app.entity.UserLogin;

public interface UserLoginService {
	
	UserLogin create(UserLogin entity);
	UserLogin update (UserLogin entity, Integer id);
	List<UserLogin> updateUserLoginStatus(Integer userId,String status);
	List<UserLogin> findAvailabe(Integer vclSizeId);
	Boolean setUserStatusLogout(Integer userId);
	

}
