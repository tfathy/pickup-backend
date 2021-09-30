package net.driver.pickupsa.app.service;

import java.util.List;

import net.driver.pickupsa.app.entity.SlOrder;
import net.driver.pickupsa.app.entity.lookup.Team;

public interface SlOrderService {
	List<SlOrder> findAvaliableOrders(Integer vclSizeId);
	SlOrder update(SlOrder entity ,Integer id);
	Team findTeamByManagerId(Integer managerId);

}
