package com.pickup.sp.controller;

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
import com.pickup.sp.entity.GnVehicle;
import com.pickup.sp.service.GnVehicleService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trx")
public class SpAppController {
	final Logger logger = LoggerFactory.getLogger(SpAppController.class);

	@Autowired
	private GnVehicleService gnVclService;

	/***********************************************
	 * GnVehicleService API
	 ******************************************************************/

	@GetMapping(value = "/sp-vcl/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Vehicles", notes = "The Api Returns List of Vehcils for a service provider", response = GnVehicle.class)
	public ResponseEntity<List<GnVehicle>> findAllVehicles(@PathVariable Integer spId) {
		List<GnVehicle> lst = this.gnVclService.findBySpId(spId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}
	
	@GetMapping(value = "/vcl/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return one Vehicle", notes = "The Api Returns a vehcils for a service provider", response = GnVehicle.class)
	public ResponseEntity<GnVehicle> findVehicleById(@PathVariable Integer id) {
		GnVehicle entity = this.gnVclService.findById(id);
		if (entity == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@PostMapping(value = "/vcl", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnVehicle> createVcl(@RequestBody GnVehicle entity) {
		GnVehicle body = this.gnVclService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/vcl/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnVehicle> updateVcl(@RequestBody GnVehicle body, @PathVariable Integer id) {
		body.setId(id);
		this.gnVclService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/vcl/{id}")
	public ResponseEntity<String> deleteVcl(@PathVariable Integer id) {
		GnVehicle entity = this.gnVclService.findById(id);
		if (entity == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Country Not Found");
		}
		String result = this.gnVclService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
