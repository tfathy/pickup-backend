package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnUom;
import com.pickup.sysowner.repos.GnUomRepos;
import com.pickup.sysowner.service.GnUomService;

@Service
public class GnUomServiceImpl implements GnUomService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnUomRepos repos;
	
	@Autowired
	public GnUomServiceImpl(GnUomRepos repos) {
		this.repos = repos;
	}
	@Override
	public List<GnUom> findAll() {
		List<GnUom> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public GnUom findById(Integer id) {
		Optional<GnUom> result = null;
		GnUom entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The UOM of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public GnUom create(GnUom body) {
		GnUom entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public GnUom update(GnUom body, Integer id) {
		GnUom oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The UOM of id " + id + " is not found-Update Faild");
		}
		GnUom newEntity = null;
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
		GnUom entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("UOM of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
