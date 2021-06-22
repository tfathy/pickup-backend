package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.HrEmployee;

public interface HrEmployeeService {
	public List<HrEmployee> findAll();
	public HrEmployee findById(Integer id);

	public HrEmployee create(HrEmployee body);
	public HrEmployee update(HrEmployee body, Integer id);
	public String delete(Integer id);
}
