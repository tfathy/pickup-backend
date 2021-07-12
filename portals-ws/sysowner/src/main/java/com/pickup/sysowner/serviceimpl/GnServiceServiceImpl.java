package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnService;
import com.pickup.sysowner.repos.GnServiceRepos;
import com.pickup.sysowner.service.GnServiceService;

@Service
public class GnServiceServiceImpl implements GnServiceService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnServiceRepos repos;
	
	@Autowired
	public GnServiceServiceImpl(GnServiceRepos repos) {
		this.repos = repos;
	}
	@Override
	public List<GnService> findAll() {
		List<GnService> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public GnService findById(Integer id) {
		Optional<GnService> result = null;
		GnService entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Service of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public GnService create(GnService body) {
		GnService entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public GnService update(GnService body, Integer id) {
		GnService oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The Service of id " + id + " is not found-Update Faild");
		}
		GnService newEntity = null;
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
		GnService entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("Service of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
