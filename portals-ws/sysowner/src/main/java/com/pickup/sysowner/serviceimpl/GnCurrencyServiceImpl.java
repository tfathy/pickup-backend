package com.pickup.sysowner.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pickup.sysowner.entity.GnCurrency;
import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.repos.GnCurrencyRepos;
import com.pickup.sysowner.service.GnCurrencyService;

@Service
public class GnCurrencyServiceImpl implements GnCurrencyService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private GnCurrencyRepos repos;

	@Autowired
	public GnCurrencyServiceImpl(GnCurrencyRepos currencyRepos) {
		this.repos = currencyRepos;
	}

	@Override
	public List<GnCurrency> findAll() {
		return this.repos.findAll();
	}

	@Override
	public GnCurrency findById(Integer id) {
		Optional<GnCurrency> result = this.repos.findById(id);
		GnCurrency currency = null;
		if (result.isPresent()) {
			currency = result.get();
		} else {
			throw new RuntimeException("The currency  of id " + id + " is not found");
		}
		return currency;
	}

	@Override
	public GnCurrency create(GnCurrency gnCurrency) {		
		return this.repos.save(gnCurrency);
	}

	@Override
	public GnCurrency update(GnCurrency gnCurrency, Integer id) {
		GnCurrency recordFound =findById(id);	
		if(recordFound== null) {
			throw new RuntimeException("The Currency of id " + id + " is not found-Update Faild");
		}
		gnCurrency.setId(id);
		return this.repos.save(gnCurrency);
	}

	@Override
	public String delete(Integer id) {
		GnCurrency currency = findById(id);
		if(currency == null) {
			throw new RuntimeException("currency of id " + id + " not found");
		}
		this.repos.deleteById(id);
		return "Deleted currency of id " + id;
	}

}
