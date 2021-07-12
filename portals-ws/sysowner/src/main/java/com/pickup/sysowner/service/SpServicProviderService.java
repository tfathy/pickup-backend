package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.SpServicProvider;

public interface SpServicProviderService {
	public List<SpServicProvider> findAll();
	public SpServicProvider findById(Integer id);

	public SpServicProvider create(SpServicProvider body);
	public SpServicProvider update(SpServicProvider body, Integer id);
	
}
