package net.driver.pickupsa.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import net.driver.pickupsa.app.entity.OrderLocation;

public interface OrderLocationRepos extends JpaRepository<OrderLocation, Integer> {

}
