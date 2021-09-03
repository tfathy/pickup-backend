package com.customer.pickup.services;

import java.util.List;

import com.customer.pickup.entity.SlOrder;

public interface SlOrderService {
	public List<SlOrder> findAll();
	public List<SlOrder> findByCustomerId(int customerId);
	public List<SlOrder> findByStatusAndCustomer(int customerId, String status);
	public SlOrder findById(int id);
	public SlOrder create(SlOrder body);
	public SlOrder update(SlOrder body, int id);
}
