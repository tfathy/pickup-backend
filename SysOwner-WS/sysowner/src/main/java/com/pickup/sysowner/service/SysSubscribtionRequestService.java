package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.SysSubscribtionRequest;


public interface SysSubscribtionRequestService {
	public List<SysSubscribtionRequest> findAll();
	public SysSubscribtionRequest findById(Integer id);

	public SysSubscribtionRequest create(SysSubscribtionRequest body);
	public SysSubscribtionRequest update(SysSubscribtionRequest body, Integer id);
}
