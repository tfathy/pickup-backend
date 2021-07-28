package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.SysSubscriptionRequest;


public interface SysSubscribtionRequestService {
	public List<SysSubscriptionRequest> findAll();
	public List<SysSubscriptionRequest> FindNew();
	public SysSubscriptionRequest findById(Integer id);

	public SysSubscriptionRequest create(SysSubscriptionRequest body);
	public SysSubscriptionRequest update(SysSubscriptionRequest body, Integer id);
}
