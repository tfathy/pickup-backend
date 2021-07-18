package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.SlTeamMember;
import com.pickup.sp.repos.SlTeamMemberRepos;
import com.pickup.sp.service.SlTeamMemberService;

@Service
public class SlTeamMemberServiceImpl implements SlTeamMemberService {

	@Autowired
	private SlTeamMemberRepos repos;

	@Override
	public List<SlTeamMember> findByTeamId(Integer teamId) {
		return repos.findByTeamId(teamId);
	}

	@Override
	public SlTeamMember findById(Integer id) {
		Optional<SlTeamMember> result = repos.findById(id);
		SlTeamMember entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SlTeamMember create(SlTeamMember entity) {
		return repos.save(entity);
	}

	@Override
	public SlTeamMember update(SlTeamMember entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		SlTeamMember entity = findById(id);
		if (entity == null) {
			return "Record " + id + " not found";
		}
		repos.deleteById(id);
		return "Record " + id + " is deleted";
	}

}
