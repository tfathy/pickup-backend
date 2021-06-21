package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.entity.GnCurrency;
import com.pickup.sysowner.repos.GnCountryRepos;
import com.pickup.sysowner.service.GnCountryService;

@Service
public class GnCountryServiceImpl implements GnCountryService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private GnCountryRepos repos;

	@Autowired
	public GnCountryServiceImpl(GnCountryRepos countryRepos) {
		this.repos = countryRepos;
	}

	@Override
	public List<GnCountry> findAll() {
		return this.repos.findAll();
	}

	@Override
	public GnCountry findById(Integer id) {
		Optional<GnCountry> result = repos.findById(id);
		GnCountry country = null;
		if (result.isPresent()) {
			country = result.get();
		} else {
			throw new RuntimeException("The country  of id " + id + " is not found");
		}
		return country;
	}

	@Override
	public GnCountry create(GnCountry gnCountry) {
		return this.repos.save(gnCountry);
	}

	@Override
	public GnCountry update(GnCountry gnCountry, Integer id) {
		GnCountry recordFound =findById(id);	
		if(recordFound== null) {
			throw new RuntimeException("The Country of id " + id + " is not found-Update Faild");
		}
		gnCountry.setId(id);
		return this.repos.save(gnCountry);
	}

	@Override
	public String delete(Integer id) {
		GnCountry country = findById(id);
		if (country == null) {
			throw new RuntimeException("Country of id " + id + " not found");
		}
		repos.deleteById(id);
		return "Deleted Country of id " + id;
	}

}
