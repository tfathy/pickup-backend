package com.customer.pickup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.pickup.entity.Customer;

public interface CustomerRepos extends JpaRepository<Customer, Integer> {

}
