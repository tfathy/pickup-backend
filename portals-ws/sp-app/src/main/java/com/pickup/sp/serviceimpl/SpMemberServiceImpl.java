package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.SpMember;
import com.pickup.sp.repos.SpMemberRepos;
import com.pickup.sp.service.SpMemberService;
@Service
public class SpMemberServiceImpl implements SpMemberService{
	
	@Autowired
	private SpMemberRepos repos;
	
	@Autowired
	private EntityManager em;

	@Override
	public List<SpMember> findBySpId(Integer spId) {
		Query query = em.createNamedQuery("findMemberBySpId");
		query.setParameter(1, spId);
		List<SpMember> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public SpMember findById(Integer id) {
		Optional<SpMember> result = repos.findById(id);
		SpMember entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SpMember create(SpMember entity) {
		return repos.save(entity);
	}

	@Override
	public SpMember update(SpMember entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		SpMember entity = findById(id);
		if(entity== null) {
			return "Employee of id["+id+"] is not found";
		}
		repos.deleteById(id);
		return "Record id ["+id+"] is deleted.";
	}

}
