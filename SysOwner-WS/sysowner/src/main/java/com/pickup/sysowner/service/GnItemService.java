package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnItem;



public interface GnItemService {
	public List<GnItem> findAll();
	public GnItem findById(Integer id);
	
	public GnItem create(GnItem item);
	public GnItem update(GnItem item, Integer id);
	public String delete(Integer id);
}
