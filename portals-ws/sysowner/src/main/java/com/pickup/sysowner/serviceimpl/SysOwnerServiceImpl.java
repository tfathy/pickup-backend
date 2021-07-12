package com.pickup.sysowner.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.SysOwner;
import com.pickup.sysowner.repos.SysOwnerRepos;
import com.pickup.sysowner.service.SysOwnerService;

@Service
public class SysOwnerServiceImpl implements SysOwnerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SysOwnerRepos repos;

	@Autowired
	public SysOwnerServiceImpl(SysOwnerRepos repos) {
		this.repos = repos;
	}

	@Override
	public SysOwner findById(Integer id) {
		Optional<SysOwner> result = null;
		SysOwner entity = null;
		try {
			result = this.repos.findById(id);
			if (result.isPresent()) {
				entity = result.get();
			} else {
				throw new RuntimeException("The owner id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public SysOwner update(SysOwner body, Integer id) {		
		try {
			body.setId(id);
			repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return body;
	}

}
