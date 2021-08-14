package com.customer.pickup.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.pickup.entity.Customer;
import com.customer.pickup.repos.CustomerRepos;
import com.customer.pickup.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepos repos;

	@Override
	public List<Customer> findAll() {
		
		return this.repos.findAll();
	}

	@Override
	public Customer findById(int id) {
		Optional<Customer> result = this.repos.findById(id);
		Customer entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public Customer create(Customer entity) {
		
		return this.repos.save(entity);
	}

	@Override
	public Customer update(Customer entity, int id) {
		entity.setId(id);
		return this.repos.save(entity);
	}

}
