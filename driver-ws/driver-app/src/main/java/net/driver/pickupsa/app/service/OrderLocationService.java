package net.driver.pickupsa.app.service;

import java.util.List;

import net.driver.pickupsa.app.entity.OrderLocation;

public interface OrderLocationService {
	
 	 List<OrderLocation> findAll();
	 OrderLocation findById(int id);
	 OrderLocation findByOrdId(Integer ordId);
	 OrderLocation create(OrderLocation body);
	 OrderLocation update(OrderLocation body, int id);
	 String delete(int id);

}
