package com.pickup.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sp.entity.GnVehicle;

public interface GnVehicleRepos extends JpaRepository<GnVehicle, Integer> {

}
