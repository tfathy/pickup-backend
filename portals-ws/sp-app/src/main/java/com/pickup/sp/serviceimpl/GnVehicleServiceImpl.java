package com.pickup.sp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sp.entity.GnVehicle;
import com.pickup.sp.repos.GnVehicleRepos;
import com.pickup.sp.service.GnVehicleService;

@Service
public class GnVehicleServiceImpl implements GnVehicleService {
	@Autowired
	private GnVehicleRepos repos;

	@Autowired
	private EntityManager em;

	@Override
	public List<GnVehicle> findBySpId(Integer spId) {
		Query query = em.createNamedQuery("findVclBySpId");
		query.setParameter(1, spId);
		List<GnVehicle> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public GnVehicle findById(Integer id) {
		Optional<GnVehicle> result = repos.findById(id);
		GnVehicle entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public GnVehicle create(GnVehicle entity) {
		return repos.save(entity);
	}

	@Override
	public GnVehicle update(GnVehicle entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		GnVehicle entity = findById(id);
		if (entity == null) {
			return "Record id[" + id + "]is not found";
		}
		repos.deleteById(id);
		return "Record Deleted";
	}

}
