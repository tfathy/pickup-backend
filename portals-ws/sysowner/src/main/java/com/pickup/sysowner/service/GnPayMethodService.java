package com.pickup.sysowner.service;

import java.util.List;

import com.pickup.sysowner.entity.GnPayMethod;

public interface GnPayMethodService {
	
	public List<GnPayMethod> findAll();
	public GnPayMethod findById(Integer id);

	public GnPayMethod create(GnPayMethod body);

	public GnPayMethod update(GnPayMethod body, Integer id);

	public String delete(Integer id);
}
