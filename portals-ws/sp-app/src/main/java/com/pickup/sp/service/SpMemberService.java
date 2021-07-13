package com.pickup.sp.service;

import java.util.List;

import com.pickup.sp.entity.SpMember;

public interface SpMemberService {
	public List<SpMember> findBySpId(Integer spId);
	public SpMember findById(Integer id);
	public SpMember create(SpMember entity);
	public SpMember update(SpMember entity,Integer id);
	public String delete(Integer id);
}
