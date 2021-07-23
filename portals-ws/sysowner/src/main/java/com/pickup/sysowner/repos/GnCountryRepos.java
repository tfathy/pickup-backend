package com.pickup.sysowner.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.GnCountry;

public interface GnCountryRepos extends JpaRepository<GnCountry, Integer> {
	
	public List<GnCountry> findByActiveFlag(String activeFlag);
}
