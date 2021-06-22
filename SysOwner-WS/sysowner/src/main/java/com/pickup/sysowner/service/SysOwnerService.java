package com.pickup.sysowner.service;


import com.pickup.sysowner.entity.SysOwner;
// only findById and update operation allowed to sys_owner table
public interface SysOwnerService {	
	public SysOwner findById(Integer id);
	public SysOwner update(SysOwner body, Integer id);	
}
