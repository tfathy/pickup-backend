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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.entity.SysSubRequestAttachments;
import com.pickup.sysowner.entity.SysSubscriptionRequest;
import com.pickup.sysowner.service.GnCountryService;
import com.pickup.sysowner.service.SysSubRequestAttachmentService;
import com.pickup.sysowner.service.SysSubscribtionRequestService;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/public")
public class SysOwnerPublicController {
	final Logger logger = LoggerFactory.getLogger(SysOwnerPublicController.class);
	@Autowired
	private SysSubscribtionRequestService sysSubscribtionRequestService;

	@Autowired
	private SysSubRequestAttachmentService sysSubRequestAttachmentService;

	@Autowired
	private GnCountryService countryService;

	@PostMapping(value = "/sub-request", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysSubscriptionRequest> createSubRequest(@RequestBody SysSubscriptionRequest entity) {
		SysSubscriptionRequest body = this.sysSubscribtionRequestService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	/***********************************************
	 * Country API
	 ******************************************************************/

	@GetMapping(value = "/country/{activeFlag}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of countries", notes = "The Api Returns List of Countries", response = GnCountry.class)
	public ResponseEntity<List<GnCountry>> findAllCountry(@PathVariable String activeFlag) {
		List<GnCountry> lst = this.countryService.findByActiveFlag(activeFlag);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	/***********************************************
	 * create Attachment entity API
	 ******************************************************************/
	@PostMapping(value = "/sub-request-attach", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save attachement record", notes = "The Api Returns used to create record in the SysSubRequestAttachments entity", response = SysSubRequestAttachments.class)
	public ResponseEntity<SysSubRequestAttachments> saveAttachmentEntity(@RequestBody SysSubRequestAttachments entity) {
		SysSubRequestAttachments body = sysSubRequestAttachmentService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@ApiOperation(value = "return list of attchments record for a request", notes = "The Api reads from the attachments table for a passed request id", response = SysSubRequestAttachments.class)
	@GetMapping(value = "/sub-request-attach/{requestId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SysSubRequestAttachments>> findAttachmentsByReqId(@PathVariable Integer requestId){
		List<SysSubRequestAttachments> resultList = sysSubRequestAttachmentService.findBySubRequestId(requestId);
		if(resultList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resultList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(resultList);
	}
	
	@ApiOperation(value = "return single attchment record ", notes = "The Api reads from the attachments table for a passed  id", response = SysSubRequestAttachments.class)
	@GetMapping(value = "/sub-request-attach/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysSubRequestAttachments> findAttachmentsById(@PathVariable Integer id){
		SysSubRequestAttachments result = sysSubRequestAttachmentService.findById(id);
		if(result == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
