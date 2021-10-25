package net.driver.pickupsa.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import net.driver.pickupsa.app.entity.UserLogin;
public interface UserLoginRepos extends JpaRepository<UserLogin, Integer> {

}
