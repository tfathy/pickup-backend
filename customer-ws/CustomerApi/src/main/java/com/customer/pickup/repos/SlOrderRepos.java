package com.customer.pickup.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.pickup.entity.SlOrder;

public interface SlOrderRepos extends JpaRepository<SlOrder, Integer> {

}
