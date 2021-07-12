package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnLocationType;

public interface GnLocationTypeService {
	
	public List<GnLocationType> findAll();
	public GnLocationType findById(Integer id);

	public GnLocationType create(GnLocationType gnLocationType);

	public GnLocationType update(GnLocationType gnLocationType, Integer id);

	public String delete(Integer id);
}
