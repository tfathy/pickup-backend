package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnVehicleSize;
import com.pickup.sysowner.repos.GnVehicleSizeRepos;
import com.pickup.sysowner.service.GnVehicleSizeService;

@Service
public class GnVehicleSizeServiceImpl implements GnVehicleSizeService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnVehicleSizeRepos repos;

	@Autowired
	public GnVehicleSizeServiceImpl(GnVehicleSizeRepos repos) {
		this.repos = repos;
	}

	@Override
	public List<GnVehicleSize> findAll() {
		List<GnVehicleSize> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public GnVehicleSize findById(Integer id) {
		Optional<GnVehicleSize> result = null;
		GnVehicleSize entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Vehicle Size of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public GnVehicleSize create(GnVehicleSize body) {
		GnVehicleSize entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public GnVehicleSize update(GnVehicleSize body, Integer id) {
		GnVehicleSize oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The Vehicle Size of id " + id + " is not found-Update Faild");
		}
		GnVehicleSize newEntity = null;
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
		GnVehicleSize entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("Vehicle Size of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
