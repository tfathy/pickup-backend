package net.driver.pickupsa.app.service;

import java.util.List;

import net.driver.pickupsa.app.entity.SlOrder;

public interface SlOrderService {
	List<SlOrder> findAvaliableOrders(Integer vclSizeId);
	SlOrder update(SlOrder entity ,Integer id);

}
