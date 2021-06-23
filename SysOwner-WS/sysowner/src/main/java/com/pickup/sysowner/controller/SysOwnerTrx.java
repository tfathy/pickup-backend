package com.pickup.sysowner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.SpServicProvider;
import com.pickup.sysowner.entity.SysSubscribtionRequest;
import com.pickup.sysowner.service.SpServicProviderService;
import com.pickup.sysowner.service.SysSubscribtionRequestService;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/trx")
public class SysOwnerTrx {
	final Logger logger = LoggerFactory.getLogger(SysOwnerTrx.class);
	@Autowired
	private SysSubscribtionRequestService sysSubscribtionRequestService;

	@Autowired
	private SpServicProviderService spServicProviderService;

	/*****************************************************************
	 * Subscription Request
	 */

	@GetMapping(value = "/sub-request", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List all the subscription requests")
	public ResponseEntity<List<SysSubscribtionRequest>> findAllSubRequest() {
		List<SysSubscribtionRequest> lst = sysSubscribtionRequestService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/sub-request/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return an object of subscribtion requests")
	public ResponseEntity<SysSubscribtionRequest> findByIdSubReq(@PathVariable Integer id) {
		SysSubscribtionRequest entity = this.sysSubscribtionRequestService.findById(id);
		if (entity == null) {
			logger.warn("Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/sub-request", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysSubscribtionRequest> createSubRequest(@RequestBody SysSubscribtionRequest entity) {
		SysSubscribtionRequest body = this.sysSubscribtionRequestService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/sub-request/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysSubscribtionRequest> updateSuRequest(@RequestBody SysSubscribtionRequest body,
			@PathVariable Integer id) {
		SysSubscribtionRequest updatedBody = this.sysSubscribtionRequestService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedBody);
	}

	/*****************************************************************
	 * Service Provider
	 ****************************************************************/

	@GetMapping(value = "/sp", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List all the Service providers")
	public ResponseEntity<List<SpServicProvider>> findAllSp() {
		List<SpServicProvider> lst = this.spServicProviderService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/sp/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return an object of Service provider")
	public ResponseEntity<SpServicProvider> findByIdSp(@PathVariable Integer id) {
		SpServicProvider entity = this.spServicProviderService.findById(id);
		if (entity == null) {
			logger.warn("Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/sp", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpServicProvider> createSp(@RequestBody SpServicProvider entity) {
		SpServicProvider body = this.spServicProviderService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/sp/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpServicProvider> updateSp(@RequestBody SpServicProvider body, @PathVariable Integer id) {
		SpServicProvider updatedBody = this.spServicProviderService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedBody);
	}

}
