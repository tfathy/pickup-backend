package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.SpJob;
import com.pickup.sp.repos.SpJobRepos;
import com.pickup.sp.service.SpJobService;

@Service
public class SpJobServiceImpl implements SpJobService {

	@Autowired
	private SpJobRepos repos;

	@Autowired
	private EntityManager em;

	@Override
	public List<SpJob> findBySpId(Integer spId) {
		Query query = em.createNamedQuery("findJobBySpId");
		query.setParameter(1, spId);
		List<SpJob> result = query.getResultList();
		return result;
	}

	@Override
	public SpJob findById(Integer id) {
		Optional<SpJob> result = repos.findById(id);
		SpJob entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SpJob create(SpJob entity) {
		return repos.save(entity);
	}

	@Override
	public SpJob update(SpJob entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		SpJob entity = findById(id);
		if (entity == null) {
			return "Record id[" + id + "]is not found";
		}
		repos.deleteById(id);
		return "Record Deleted";
	}

}
