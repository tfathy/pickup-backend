package com.pickup.sysowner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.service.GnCountryService;

@RestController
@RequestMapping("/sys-owner/def")
public class SysOwnerDefController {
	
	final Logger logger = LoggerFactory.getLogger(SysOwnerDefController.class);	
	
	@Autowired
	private GnCountryService countryService;
	
	@GetMapping(value="/country",produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<GnCountry> findAll(){
		return this.countryService.findAll();
	}
	

}
