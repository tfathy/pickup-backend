package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnItemService;
import com.pickup.sysowner.repos.GnItemServiceRepos;
import com.pickup.sysowner.service.GnItemServiceService;
@Service
public class GnItemServiceServiceImpl implements GnItemServiceService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnItemServiceRepos repos;

	@Autowired
	public GnItemServiceServiceImpl(GnItemServiceRepos serviceRepos) {
		this.repos = serviceRepos;
	}

	@Override
	public List<com.pickup.sysowner.entity.GnItemService> findAll() {
		List<com.pickup.sysowner.entity.GnItemService> lst = null;
		try {
			lst = this.repos.findAll();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public com.pickup.sysowner.entity.GnItemService findById(Integer id) {
		com.pickup.sysowner.entity.GnItemService entity = null;
		try {
			Optional<com.pickup.sysowner.entity.GnItemService> result = this.repos.findById(id);
			if (result.isPresent()) {
				entity = result.get();
			}else {
				throw new RuntimeException("The Item-service of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public com.pickup.sysowner.entity.GnItemService create(com.pickup.sysowner.entity.GnItemService itemService) {
		com.pickup.sysowner.entity.GnItemService newEntity = null;
		try {
			newEntity = this.repos.save(itemService);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newEntity;
	}

	@Override
	public com.pickup.sysowner.entity.GnItemService update(com.pickup.sysowner.entity.GnItemService itemService,
			Integer id) {
		com.pickup.sysowner.entity.GnItemService itemFound =findById(id);	
		if(itemFound== null) {
			throw new RuntimeException("The Item-service of id " + id + " is not found-Update Faild");
		}
		com.pickup.sysowner.entity.GnItemService newItem = null;
		try {
			itemService.setId(id);
			newItem = repos.save(itemService);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newItem;
	}

	@Override
	public String delete(Integer id) {
		com.pickup.sysowner.entity.GnItemService item = findById(id);
		if (item == null) {
			throw new RuntimeException("Item-service of id " + id + " not found");
		}
		this.repos.delete(item);
		return "One Record Deleted";
	}

	@Override
	public List<GnItemService> findByItemId(Integer itemId) {
		
		return this.repos.findByItenId(itemId);
	}

}
