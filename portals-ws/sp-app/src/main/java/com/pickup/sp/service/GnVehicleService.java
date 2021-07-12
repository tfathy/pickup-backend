package com.pickup.sp.service;

import java.util.List;

import com.pickup.sp.entity.GnVehicle;

public interface GnVehicleService {
	public List<GnVehicle> findBySpId(Integer spId);
	public GnVehicle findById(Integer id);
	public GnVehicle create(GnVehicle entity);
	public GnVehicle update(GnVehicle entity,Integer id);
	public String delete(Integer id);
}
