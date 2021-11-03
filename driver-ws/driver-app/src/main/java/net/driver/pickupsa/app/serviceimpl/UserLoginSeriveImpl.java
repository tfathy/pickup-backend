package net.driver.pickupsa.app.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.driver.pickupsa.app.entity.UserLogin;
import net.driver.pickupsa.app.repos.UserLoginRepos;
import net.driver.pickupsa.app.service.UserLoginService;

@Transactional
@Service
public class UserLoginSeriveImpl implements UserLoginService {

	@Autowired
	private UserLoginRepos repos;

	@Autowired
	@PersistenceContext
	private EntityManager em;

	@Override
	public UserLogin create(UserLogin entity) {
		boolean b = setUserStatusLogout(entity.getSysUser().getId());
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

	@Override
	@Transactional
	public Boolean setUserStatusLogout(Integer userId) {
		boolean result = false;
		try {
			Query updateQuery = em.createNamedQuery("updateUserLogin");
			updateQuery.setParameter(1, userId);
			updateQuery.executeUpdate();
			System.out.println("setUserStatusLogout done **********");
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		;
		return result;
	}

	@Override
	@Transactional
	public Boolean updateUserLoginStatus(String userId, String oldStatus, String newStatus) {
		try {
			List<UserLogin> updatedEntities = null;
			Query updateQuery = em.createNamedQuery("updateUsaerLoginStatus");
			updateQuery.setParameter(1, userId);
			updateQuery.setParameter(2, oldStatus);
			updateQuery.setParameter(3, newStatus);
			updateQuery.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
