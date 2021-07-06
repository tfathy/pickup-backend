package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnItemCategory;
import com.pickup.sysowner.repos.GnItemRepos;
import com.pickup.sysowner.service.GnItemService;

@Service
public class GnItemServiceImpl implements GnItemService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private GnItemRepos repos;
	private EntityManager em;

	@Autowired
	public GnItemServiceImpl(GnItemRepos itemRepos, EntityManager e) {
		this.repos = itemRepos;
		this.em = e;
	}

	@Override
	public List<GnItem> findAll() {
		List<GnItem> body = null;
		try {
			body = this.repos.findAll();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return body;
	}

	@Override
	public GnItem findById(Integer id) {
		Optional<GnItem> result = null;
		GnItem item = null;
		try {
			result = this.repos.findById(id);
			if(result.isPresent()) {
				item = result.get();
			}else {
				throw new RuntimeException("The Item of id " + id + " is not found");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return item;
	}

	@Override
	public GnItem create(GnItem item) {
		GnItem newItem = null;
		try {
			newItem = this.repos.save(item);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newItem;
	}

	@Override
	public GnItem update(GnItem item, Integer id) {
		GnItem itemFound =findById(id);	
		if(itemFound== null) {
			throw new RuntimeException("The Item of id " + id + " is not found-Update Faild");
		}
		GnItem newItem = null;
		try {
			item.setId(id);
			newItem = repos.save(item);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		return newItem;
	}

	@Override
	public String delete(Integer id) {
		GnItem item = findById(id);
		if (item == null) {
			throw new RuntimeException("Item of id " + id + " not found");
		}
		this.repos.delete(item);
		return "One Record Deleted";
	}

	@Override
	public List<GnItem> findByGnItemCategory(GnItemCategory gnItemCategory) {
		return this.repos.findByGnItemCategory(gnItemCategory);
	}

	@Override
	public List<GnItem> findByCatId(Integer catId) {
		Query query = em.createNamedQuery("findByCatId");
		query.setParameter(1, catId);
		List<GnItem> entityList = query.getResultList();
		return entityList;
	}

	

}
