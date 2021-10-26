package com.customer.pickup.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.pickup.entity.OrderImages;

public interface OrderImagesRepos extends JpaRepository<OrderImages, Integer> {
	
	List<OrderImages> findByOrdId(Integer ordId);

}
