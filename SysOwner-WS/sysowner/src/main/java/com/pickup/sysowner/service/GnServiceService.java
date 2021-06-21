package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnService;

public interface GnServiceService {
	public List<GnService> findAll();
	public GnService findById(Integer id);

	public GnService create(GnService body);
	public GnService update(GnService body, Integer id);
	public String delete(Integer id);
}
