package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.SlTeam;
import com.pickup.sp.entity.SlTeamMember;
import com.pickup.sp.repos.SlTeamRepos;
import com.pickup.sp.service.SlTeamService;

@Service
public class SlTeamServiceImpl implements SlTeamService {

	@Autowired
	private SlTeamRepos repos;

	@Autowired
	private EntityManager em;

	@Override
	public List<SlTeam> findBySpId(Integer spId) {
		Query query = em.createNamedQuery("findTeamBySpId");
		query.setParameter(1, spId);
		List<SlTeam> list = query.getResultList();
		return list;
	}

	@Override
	public SlTeam findById(Integer id) {
		Optional<SlTeam> result = repos.findById(id);
		SlTeam entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SlTeam create(SlTeam entity) {		
		return repos.save(entity);
	}

	@Override
	public SlTeam update(SlTeam entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		SlTeam entity = findById(id);
		if (entity == null) {
			return "Record [" + id + "] not found";
		}
		repos.deleteById(id);
		return "Record [" + id + "] is deleted";
	}

}
