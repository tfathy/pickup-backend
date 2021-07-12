package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnPayMethod;
import com.pickup.sysowner.repos.GnPayMethodRepos;
import com.pickup.sysowner.service.GnPayMethodService;

@Service
public class GnPayMethodServiceImpl implements GnPayMethodService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private GnPayMethodRepos repos;
	
	@Autowired
	public GnPayMethodServiceImpl(GnPayMethodRepos repos) {
		this.repos = repos;
	}
	@Override
	public List<GnPayMethod> findAll() {
		List<GnPayMethod> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public GnPayMethod findById(Integer id) {
		Optional<GnPayMethod> result = null;
		GnPayMethod entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The payment method of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public GnPayMethod create(GnPayMethod body) {
		GnPayMethod entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public GnPayMethod update(GnPayMethod body, Integer id) {
		GnPayMethod oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The Pay method of id " + id + " is not found-Update Faild");
		}
		GnPayMethod newEntity = null;
		try {
			oldEntity.setId(id);
			newEntity = repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newEntity;
	}

	@Override
	public String delete(Integer id) {
		GnPayMethod entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("Pay method of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
