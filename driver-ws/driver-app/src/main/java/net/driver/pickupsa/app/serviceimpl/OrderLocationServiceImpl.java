package net.driver.pickupsa.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.driver.pickupsa.app.entity.OrderLocation;
import net.driver.pickupsa.app.repos.OrderLocationRepos;
import net.driver.pickupsa.app.service.OrderLocationService;

@Service
public class OrderLocationServiceImpl implements OrderLocationService {

	@Autowired
	private OrderLocationRepos repos;

	@Autowired
	private EntityManager em;

	@Override
	public List<OrderLocation> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public OrderLocation findById(int id) {
		Optional<OrderLocation> result = repos.findById(id);
		OrderLocation entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public OrderLocation findByOrdId(Integer ordId) {
		OrderLocation entity = null;
		try {
			Query query = em.createNamedQuery("findOrdLocByOrderId");
			query.setParameter(1, ordId);
			entity = (OrderLocation) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public OrderLocation create(OrderLocation body) {
		return repos.save(body);
	}

	@Override
	public OrderLocation update(OrderLocation body, int id) {
		body.setId(id);
		return repos.save(body);
	}

	@Override
	public String delete(int id) {
		OrderLocation entity = findById(id);
		if (entity == null) {
			return "No records to be deleted";
		}
		repos.deleteById(id);
		return "record " + id + " is deleted successfully";
	}

}
