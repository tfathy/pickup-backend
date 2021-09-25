package net.driver.pickupsa.app.serviceimpl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.driver.pickupsa.app.entity.UserLogin;
import net.driver.pickupsa.app.repos.UserLoginRepos;
import net.driver.pickupsa.app.service.UserLoginService;

@Service
public class UserLoginSeriveImpl implements UserLoginService {

	@Autowired
	private UserLoginRepos repos;
	
	@Autowired
	private EntityManager em;



	@Override
	public UserLogin create(UserLogin entity) {

		return repos.save(entity);
	}

	@Override
	public UserLogin update(UserLogin entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public List<UserLogin> findAvailabe(Integer vclSizeId) {
		List<UserLogin> result = null;
		Query query = em.createNamedQuery("availableDrivers");
		query.setParameter(1, vclSizeId);
		result = query.getResultList();
		return result;
	}


}
