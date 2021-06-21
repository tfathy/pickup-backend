package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnItemCategory;
import com.pickup.sysowner.repos.GnItemCategoryRepos;
import com.pickup.sysowner.service.GnItemCategoryService;

@Service
public class GnItemCategoryServiceImpl implements GnItemCategoryService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnItemCategoryRepos repos;
	
	@Autowired
	public GnItemCategoryServiceImpl(GnItemCategoryRepos catRepo) {
		this.repos = catRepo;
	}
	
	@Override
	public List<GnItemCategory> findAll() {
		
		List<GnItemCategory> body = null;
		try {
			body = this.repos.findAll();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return body;
	}

	@Override
	public GnItemCategory findById(Integer id) {
		Optional<GnItemCategory> result = null;
		GnItemCategory cat = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				cat = result.get();
			}else {
				throw new RuntimeException("The Item Category of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return cat;
	}

	@Override
	public GnItemCategory create(GnItemCategory category) {
		GnItemCategory newRecord = null;
		try {
			newRecord = this.repos.save(category);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newRecord;
	}

	@Override
	public GnItemCategory update(GnItemCategory category, Integer id) {
		GnItemCategory cat =findById(id);	
		if(cat== null) {
			throw new RuntimeException("The Item category of id " + id + " is not found-Update Faild");
		}
		GnItemCategory newCat = null;
		try {
			cat.setId(id);
			newCat = repos.save(cat);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newCat;
	}

	@Override
	public String delete(Integer id) {
		GnItemCategory record = findById(id);
		if (record == null) {
			throw new RuntimeException("Item category of id " + id + " not found");
		}
		this.repos.delete(record);
		return null;
	}

}
