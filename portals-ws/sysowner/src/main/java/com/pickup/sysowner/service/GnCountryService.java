package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnCountry;

public interface GnCountryService {
	
	public List<GnCountry> findAll();
	public GnCountry findById(Integer id);
	
	public GnCountry create(GnCountry gnCountry);
	public GnCountry update(GnCountry gnCountry, Integer id);
	public String delete(Integer id);
	

}
