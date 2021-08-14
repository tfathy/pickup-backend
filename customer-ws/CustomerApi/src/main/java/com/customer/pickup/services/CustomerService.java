package com.customer.pickup.services;

import java.util.List;

import com.customer.pickup.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
	Customer findById(int id);
	Customer create(Customer entity);
	Customer update(Customer entity, int id);
	
}
