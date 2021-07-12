package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnUom;


public interface GnUomService {
	public List<GnUom> findAll();
	public GnUom findById(Integer id);

	public GnUom create(GnUom body);
	public GnUom update(GnUom body, Integer id);
	public String delete(Integer id);
}
