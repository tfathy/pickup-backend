package com.pickup.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sp.entity.SlOrder;

public interface SlOrderRepos extends JpaRepository<SlOrder, Integer> {

}
