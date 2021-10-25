package com.customer.pickup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.pickup.entity.OrderImages;
import com.customer.pickup.repos.OrderImagesRepos;
import com.customer.pickup.serviceimpl.OrderImagesService;

@Service
public class OrderImagesServiceImpl implements OrderImagesService {
	
	@Autowired
	private OrderImagesRepos repos;

	@Override
	public List<OrderImages> findAll() {
		// TODO Auto-generated method stub
		return this.repos.findAll();
	}

	@Override
	public OrderImages findById(int id) {
		Optional<OrderImages> result= repos.findById(id);
		OrderImages entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public OrderImages save(OrderImages entity) {
		// TODO Auto-generated method stub
		return this.repos.save(entity);
	}

	@Override
	public OrderImages update(OrderImages entity, int id) {
		entity.setId(id);		
		return repos.save(entity);
	}

}
