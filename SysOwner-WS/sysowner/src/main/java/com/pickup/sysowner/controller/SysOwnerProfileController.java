package com.pickup.sysowner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.entity.SysOwner;
import com.pickup.sysowner.service.SysOwnerService;

@RestController
@RequestMapping("/profile")
public class SysOwnerProfileController {
	final Logger logger = LoggerFactory.getLogger(SysOwnerProfileController.class);
	
	@Autowired
	private SysOwnerService sysOwnerService;
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysOwner> findByIdCountry(@PathVariable Integer id) {
		SysOwner entity = this.sysOwnerService.findById(id);
		if (entity == null) {
			logger.warn("Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysOwner> updateCountry(@RequestBody SysOwner body, @PathVariable Integer id) {
		
		
		this.sysOwnerService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
}
