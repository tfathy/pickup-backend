package com.pickup.sp.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.pickup.sp.entity.GnVehicle;
import com.pickup.sp.repos.GnVehicleRepos;
import com.pickup.sp.service.GnVehicleService;

public class GnVehicleServiceImpl implements GnVehicleService {
	@Autowired
	private GnVehicleRepos repos;
	
	@Autowired
	private EntityManager em;

	@Override
	public List<GnVehicle> findBySpId(Integer spId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GnVehicle findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GnVehicle create(GnVehicle entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GnVehicle update(GnVehicle entity, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
