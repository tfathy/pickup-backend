package com.pickup.sp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sp.entity.SlTeamMember;

public interface SlTeamMemberRepos extends JpaRepository<SlTeamMember, Integer> {
	public List<SlTeamMember> findByTeamId(Integer teamId);

}
