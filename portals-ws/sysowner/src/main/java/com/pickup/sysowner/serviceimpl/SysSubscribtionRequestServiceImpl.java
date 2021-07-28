package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.SysSubscriptionRequest;
import com.pickup.sysowner.repos.SysSubscribtionRequestRepos;
import com.pickup.sysowner.service.SysSubscribtionRequestService;
@Service
public class SysSubscribtionRequestServiceImpl implements SysSubscribtionRequestService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SysSubscribtionRequestRepos repos;
	private EntityManager em;
	
	@Autowired
	public SysSubscribtionRequestServiceImpl(SysSubscribtionRequestRepos repos, EntityManager em) {
		this.repos = repos;
		this.em= em;
	}
	
	@Override
	public List<SysSubscriptionRequest> findAll() {
		List<SysSubscriptionRequest> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}
	@Override
	public SysSubscriptionRequest findById(Integer id) {
		Optional<SysSubscriptionRequest> result = null;
		SysSubscriptionRequest entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Request of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}
	@Override
	public SysSubscriptionRequest create(SysSubscriptionRequest body) {
		SysSubscriptionRequest entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}
	@Override
	public SysSubscriptionRequest update(SysSubscriptionRequest body, Integer id) {
		body.setId(id);
		return this.repos.save(body);
	}

	@Override
	public List<SysSubscriptionRequest> FindNew() {
		Query query = em.createNamedQuery("findNew");
		List<SysSubscriptionRequest> entityList = query.getResultList();
		return entityList;
	}
}
