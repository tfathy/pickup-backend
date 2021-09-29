package net.driver.pickupsa.app.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.driver.pickupsa.app.entity.SlOrder;
import net.driver.pickupsa.app.repos.SlOrderRepos;
import net.driver.pickupsa.app.service.SlOrderService;

@Service
public class SlOrderServiceImpl implements SlOrderService {

	@Autowired
	private EntityManager em;

	@Autowired
	private SlOrderRepos repos;

	@Override
	public List<SlOrder> findAvaliableOrders(Integer vclSizeId) {
		List<SlOrder> result = null;
		Query query = em.createNamedQuery("avaliableOrdersByVclSize");
		query.setParameter(1, vclSizeId);
		result = query.getResultList();
		return result;
	}

	@Override
	public SlOrder update(SlOrder entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

}
