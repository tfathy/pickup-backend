package com.pickup.sp.service;

import java.util.List;

import com.pickup.sp.entity.SlTeamMember;



public interface SlTeamMemberService {
	public List<SlTeamMember> findByTeamId(Integer teamId);
	public SlTeamMember findById(Integer id);
	public SlTeamMember create(SlTeamMember entity);
	public SlTeamMember update(SlTeamMember entity,Integer id);
	public String delete(Integer id);	

}
