package net.driver.pickupsa.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.driver.pickupsa.app.entity.SlOrder;

public interface SlOrderRepos extends JpaRepository<SlOrder, Integer> {

}
