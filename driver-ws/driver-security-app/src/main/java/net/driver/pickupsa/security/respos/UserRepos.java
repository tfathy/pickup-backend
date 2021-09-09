package net.driver.pickupsa.security.respos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.driver.pickupsa.security.entity.DriverUser;

public interface UserRepos extends JpaRepository<DriverUser, Integer> {
	
	DriverUser findByEmail(String email);
	DriverUser findByUserId(String userId);
	DriverUser findById(int id);
	

}
