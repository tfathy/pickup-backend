package com.pickup.sysowner.service;

import java.util.List;

public interface GnItemServiceService {
	public List<com.pickup.sysowner.entity.GnItemService> findAll();

	public com.pickup.sysowner.entity.GnItemService findById(Integer id);
	
	public List<com.pickup.sysowner.entity.GnItemService> findByItemId( Integer itemId);

	public com.pickup.sysowner.entity.GnItemService create(com.pickup.sysowner.entity.GnItemService itemService);

	public com.pickup.sysowner.entity.GnItemService update(com.pickup.sysowner.entity.GnItemService itemService,
			Integer id);

	public String delete(Integer id);
}
