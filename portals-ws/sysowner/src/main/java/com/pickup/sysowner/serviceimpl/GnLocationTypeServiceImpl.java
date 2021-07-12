package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnLocationType;
import com.pickup.sysowner.repos.GnLocationTypeRepos;
import com.pickup.sysowner.service.GnLocationTypeService;

@Service
public class GnLocationTypeServiceImpl implements GnLocationTypeService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnLocationTypeRepos repos;
	
	@Autowired
	public GnLocationTypeServiceImpl(GnLocationTypeRepos locRepos) {
		this.repos = locRepos;
	}
	@Override
	public List<GnLocationType> findAll() {
		List<GnLocationType> body = null;
		try {
			body = this.repos.findAll();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return body;
	}

	@Override
	public GnLocationType findById(Integer id) {
		Optional<GnLocationType> result = null;
		GnLocationType entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Location Type of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public GnLocationType create(GnLocationType gnLocationType) {
		GnLocationType entity = null;
		try {
			entity = this.repos.save(gnLocationType);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public GnLocationType update(GnLocationType gnLocationType, Integer id) {
		GnLocationType oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The Location Type of id " + id + " is not found-Update Faild");
		}
		GnLocationType newEntity = null;
		try {
			oldEntity.setId(id);
			newEntity = repos.save(gnLocationType);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newEntity;
	}

	@Override
	public String delete(Integer id) {
		GnLocationType entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("Location Type of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
