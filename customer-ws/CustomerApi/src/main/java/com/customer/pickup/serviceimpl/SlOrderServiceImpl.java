package com.customer.pickup.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.pickup.entity.SlOrder;
import com.customer.pickup.repos.SlOrderRepos;
import com.customer.pickup.services.SlOrderService;

@Service
public class SlOrderServiceImpl implements SlOrderService {

	@Autowired
	private EntityManager em;

	@Autowired
	private SlOrderRepos repos;

	@Override
	public List<SlOrder> findAll() {		
		return repos.findAll();
	}

	@Override
	public List<SlOrder> findByCustomerId(int customerId) {
		Query query = em.createNamedQuery("findOrdByCustomerId");
		query.setParameter(1, customerId);
		List<SlOrder> entityList = query.getResultList();
		return entityList;
	}

	@Override
	public SlOrder findById(int id) {
		Optional<SlOrder> result = repos.findById(id);
		SlOrder entity = null;
		if(result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public SlOrder create(SlOrder body) {		
		return repos.save(body);
	}

	@Override
	public SlOrder update(SlOrder body, int id) {
		body.setId(id);
		return repos.save(body);
	}

	@Override
	public List<SlOrder> findByStatusAndCustomer(int customerId, String status) {
		Query query = em.createNamedQuery("findOrdByCustmerAndStatus");
		query.setParameter(1, customerId);
		query.setParameter(2, status);
		List<SlOrder> entityList = query.getResultList();
		return entityList;
	}

}
