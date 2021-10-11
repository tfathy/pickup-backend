package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.SysSubRequestAttachments;

public interface SysSubRequestAttachmentService {

	public  List<SysSubRequestAttachments> findAll();
	public SysSubRequestAttachments findById(Integer id);
	public List<SysSubRequestAttachments> findBySubRequestId(Integer subRrequestId);
	
	public SysSubRequestAttachments create(SysSubRequestAttachments entity);
	public SysSubRequestAttachments update(SysSubRequestAttachments entity,Integer id);
	public void delet(Integer id);
	
}
