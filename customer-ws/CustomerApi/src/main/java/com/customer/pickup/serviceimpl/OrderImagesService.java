package com.customer.pickup.serviceimpl;

import java.util.List;

import com.customer.pickup.entity.OrderImages;

public interface OrderImagesService {
	
	public List<OrderImages> findAll();
	
	public OrderImages findById(int id);
	
	public OrderImages save(OrderImages entity);
	
	public OrderImages update(OrderImages entity,int id);

}
