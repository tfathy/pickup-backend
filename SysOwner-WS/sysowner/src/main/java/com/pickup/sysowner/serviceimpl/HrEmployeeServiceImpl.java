package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.HrEmployee;
import com.pickup.sysowner.repos.HrEmployeeRepos;
import com.pickup.sysowner.service.HrEmployeeService;

@Service
public class HrEmployeeServiceImpl implements HrEmployeeService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private HrEmployeeRepos repos;
	
	@Autowired
	public HrEmployeeServiceImpl (HrEmployeeRepos repos) {
		this.repos = repos;
	}
	@Override
	public List<HrEmployee> findAll() {
		List<HrEmployee> entityList = null;
		try {
			entityList = this.repos.findAll();			
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entityList;
	}

	@Override
	public HrEmployee findById(Integer id) {
		Optional<HrEmployee> result = null;
		HrEmployee entity = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Employee of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return entity;
	}

	@Override
	public HrEmployee create(HrEmployee body) {
		HrEmployee entity = null;
		try {
			entity = this.repos.save(body);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public HrEmployee update(HrEmployee body, Integer id) {
		HrEmployee oldEntity =findById(id);	
		if(oldEntity== null) {
			throw new RuntimeException("The Employee of id " + id + " is not found-Update Faild");
		}
		HrEmployee newEntity = null;
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
		HrEmployee entity = findById(id);
		if (entity == null) {
			throw new RuntimeException("Employee of id " + id + " not found");
		}
		this.repos.delete(entity);
		return "One Record Deleted";
	}

}
