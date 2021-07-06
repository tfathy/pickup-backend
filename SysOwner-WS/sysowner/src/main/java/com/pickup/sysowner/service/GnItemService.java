package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnItemCategory;



public interface GnItemService {
	public List<GnItem> findAll();
	public GnItem findById(Integer id);
	public List<GnItem> findByGnItemCategory(GnItemCategory gnItemCategory);
	
	public GnItem create(GnItem item);
	public GnItem update(GnItem item, Integer id);
	public String delete(Integer id);
	public List<GnItem> findByCatId(Integer catId);
}
