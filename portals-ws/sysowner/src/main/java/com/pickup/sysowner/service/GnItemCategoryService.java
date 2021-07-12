package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnItemCategory;

public interface GnItemCategoryService {
	public List<GnItemCategory> findAll();
	public GnItemCategory findById(Integer id);
	
	public GnItemCategory create(GnItemCategory category);
	public GnItemCategory update(GnItemCategory category, Integer id);
	public String delete(Integer id);
}
