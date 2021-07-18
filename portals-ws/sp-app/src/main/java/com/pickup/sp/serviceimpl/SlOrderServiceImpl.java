package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.SlOrder;
import com.pickup.sp.repos.SlOrderRepos;
import com.pickup.sp.service.SlOrderService;
@Service
public class SlOrderServiceImpl implements SlOrderService {

	@Autowired
	private EntityManager em;

	@Autowired
	private SlOrderRepos repos;

	@Override
	public List<SlOrder> findBySpId(Integer spId) {
		Query query = em.createNamedQuery("findBySpId");
		query.setParameter(1, spId);
		List<SlOrder> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<SlOrder> findByCustomerId(Integer customerId) {
		Query query = em.createNamedQuery("findByCustomerId");
		query.setParameter(1, customerId);
		List<SlOrder> resultList = query.getResultList();
		return null;
	}

	@Override
	public List<SlOrder> findByTeamId(Integer teamId) {
		Query query = em.createNamedQuery("findByTeamId");
		query.setParameter(1, teamId);
		List<SlOrder> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<SlOrder> findByOrdStatus(Integer spId, String ordStatus) {
		Query query = em.createNamedQuery("findByOrdStatus");
		query.setParameter(1, spId);
		query.setParameter(2, ordStatus);
		List<SlOrder> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public SlOrder findById(Integer id) {
		Optional<SlOrder> result = repos.findById(id);
		SlOrder entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SlOrder create(SlOrder entity) {
		return repos.save(entity);
	}

	@Override
	public SlOrder update(SlOrder entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		SlOrder entity = findById(id);
		if (entity == null) {
			return "Record[" + id + "] Not Found";
		}
		repos.deleteById(id);
		return "Record[" + id + "] is deleted";
	}

}
