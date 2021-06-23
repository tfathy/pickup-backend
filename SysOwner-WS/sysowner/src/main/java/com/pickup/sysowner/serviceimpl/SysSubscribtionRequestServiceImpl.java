package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.SysSubscribtionRequest;
import com.pickup.sysowner.repos.SysSubscribtionRequestRepos;
import com.pickup.sysowner.service.SysSubscribtionRequestService;
@Service
public class SysSubscribtionRequestServiceImpl implements SysSubscribtionRequestService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SysSubscribtionRequestRepos repos;
	
	@Autowired
	public SysSubscribtionRequestServiceImpl(SysSubscribtionRequestRepos repos) {
		this.repos = repos;
	}
	
	@Override
	public List<SysSubscribtionRequest> findAll() {
		List<SysSubscribtionRequest> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}
	@Override
	public SysSubscribtionRequest findById(Integer id) {
		Optional<SysSubscribtionRequest> result = null;
		SysSubscribtionRequest entity = null;
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
	public SysSubscribtionRequest create(SysSubscribtionRequest body) {
		SysSubscribtionRequest entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}
	@Override
	public SysSubscribtionRequest update(SysSubscribtionRequest body, Integer id) {
		body.setId(id);
		return this.repos.save(body);
	}
}
