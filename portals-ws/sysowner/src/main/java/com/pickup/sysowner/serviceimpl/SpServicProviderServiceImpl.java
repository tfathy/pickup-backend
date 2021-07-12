package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.SpServicProvider;
import com.pickup.sysowner.repos.SpServicProviderRepos;
import com.pickup.sysowner.service.SpServicProviderService;

@Service
public class SpServicProviderServiceImpl implements SpServicProviderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private SpServicProviderRepos repos;
	
	@Autowired
	public SpServicProviderServiceImpl(SpServicProviderRepos repos) {
		this.repos = repos;
	}
	@Override
	public List<SpServicProvider> findAll() {
		
		List<SpServicProvider> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public SpServicProvider findById(Integer id) {
		Optional<SpServicProvider> result = null;
		SpServicProvider entity = null;
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
	public SpServicProvider create(SpServicProvider body) {
		SpServicProvider entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public SpServicProvider update(SpServicProvider body, Integer id) {
		body.setId(id);
		return this.repos.save(body);
	}

}
