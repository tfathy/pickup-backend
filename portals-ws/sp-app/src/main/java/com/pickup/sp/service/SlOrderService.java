package com.pickup.sp.service;

import java.util.List;

import com.pickup.sp.entity.SlOrder;

public interface SlOrderService {
	public List<SlOrder> findBySpId(Integer spId);
	public List<SlOrder> findByCustomerId(Integer customerId);
	public List<SlOrder> findByTeamId(Integer teamId);
	public List<SlOrder> findByOrdStatus(Integer spId,String ordStatus);
	public SlOrder findById(Integer id);
	public SlOrder create(SlOrder entity);
	public SlOrder update(SlOrder entity,Integer id);
	public String delete(Integer id);	

}
