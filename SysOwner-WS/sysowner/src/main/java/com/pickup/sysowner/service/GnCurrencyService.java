package com.pickup.sysowner.service;

import java.util.List;


import com.pickup.sysowner.entity.GnCurrency;



public interface GnCurrencyService {
//GnCurrency
	public List<GnCurrency> findAll();
	public GnCurrency findById(Integer id);
	
	public GnCurrency create(GnCurrency gnCurrency);
	public GnCurrency update(GnCurrency gnCurrency, Integer id);
	public String delete(Integer id);
	
}
