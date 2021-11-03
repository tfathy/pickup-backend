package net.driver.pickupsa.app.service;


import java.util.List;

import net.driver.pickupsa.app.entity.UserLogin;

public interface UserLoginService {
	
	UserLogin create(UserLogin entity);
	UserLogin update (UserLogin entity, Integer id);
	Boolean updateUserLoginStatus(String userId,String oldStatus, String newStatus);
	List<UserLogin> findAvailabe(Integer vclSizeId);
	Boolean setUserStatusLogout(Integer userId);
	

}
