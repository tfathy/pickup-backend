package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnVehicleSize;


public interface GnVehicleSizeService {
	public List<GnVehicleSize> findAll();
	public GnVehicleSize findById(Integer id);

	public GnVehicleSize create(GnVehicleSize body);
	public GnVehicleSize update(GnVehicleSize body, Integer id);
	public String delete(Integer id);
}
