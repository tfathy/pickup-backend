package com.pickup.sp.service;

import java.util.List;

import com.pickup.sp.entity.SpJob;

public interface SpJobService {
	public List<SpJob> findBySpId(Integer spId);
	public SpJob findById(Integer id);
	public SpJob create(SpJob entity);
	public SpJob update(SpJob entity,Integer id);
	public String delete(Integer id);
}
