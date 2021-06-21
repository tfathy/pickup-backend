package com.pickup.sysowner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.entity.GnCurrency;
import com.pickup.sysowner.service.GnCountryService;
import com.pickup.sysowner.service.GnCurrencyService;

@RestController
@RequestMapping("/sys-owner/def")
public class SysOwnerDefController {

	final Logger logger = LoggerFactory.getLogger(SysOwnerDefController.class);

	@Autowired
	private GnCountryService countryService;

	@Autowired
	private GnCurrencyService currencyService;

	/***********************************************
	 * Country API
	 ******************************************************************/

	@GetMapping(value = "/country", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnCountry>> findAllCountry() {
		List<GnCountry> lst = this.countryService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/country/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCountry> findByIdCountry(@PathVariable Integer id) {
		GnCountry entity = this.countryService.findById(id);
		if (entity == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/country", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCountry> createCountry(@RequestBody GnCountry entity) {
		GnCountry body = this.countryService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/country/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCountry> updateCountry(@RequestBody GnCountry body, @PathVariable Integer id) {
		GnCountry country = this.countryService.findById(id);
		if (country == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(country);
		}
		this.countryService.update(country, id);
		return ResponseEntity.status(HttpStatus.OK).body(country);
	}

	@DeleteMapping(value = "/country/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable Integer id) {
		GnCountry country = this.countryService.findById(id);
		if (country == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Country Not Found");
		}
		String result = this.countryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Currency API
	 ******************************************************************/
	@GetMapping(value = "/currency", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnCurrency>> findAllCurrency() {
		List<GnCurrency> lst = this.currencyService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

}
