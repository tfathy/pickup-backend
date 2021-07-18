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
import com.pickup.sp.entity.SlOrder;
import com.pickup.sp.entity.SlTeam;
import com.pickup.sp.entity.SpJob;
import com.pickup.sp.entity.SpMember;
import com.pickup.sp.service.GnVehicleService;
import com.pickup.sp.service.SlOrderService;
import com.pickup.sp.service.SlTeamService;
import com.pickup.sp.service.SpJobService;
import com.pickup.sp.service.SpMemberService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trx")
public class SpAppController {
	final Logger logger = LoggerFactory.getLogger(SpAppController.class);

	@Autowired
	private GnVehicleService gnVclService;

	@Autowired
	private SpMemberService spMemberService;

	@Autowired
	private SpJobService spJobService;

	@Autowired
	private SlTeamService slTeamService;

	@Autowired
	private SlOrderService slOrderService;

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
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Vehcile Not Found");
		}
		String result = this.gnVclService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * SpMember API
	 ******************************************************************/
	@GetMapping(value = "/sp-member/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Employees", notes = "The Api Returns List of Employees for a service provider", response = SpMember.class)
	public ResponseEntity<List<SpMember>> findAllSpMember(@PathVariable Integer spId) {
		List<SpMember> lst = this.spMemberService.findBySpId(spId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/member/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return one Employee", notes = "The Api Returns an employee for a service provider", response = SpMember.class)
	public ResponseEntity<SpMember> findSpMemberById(@PathVariable Integer id) {
		SpMember entity = this.spMemberService.findById(id);
		if (entity == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/member", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpMember> createSpMember(@RequestBody SpMember entity) {
		SpMember body = this.spMemberService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/member/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpMember> updateSpMember(@RequestBody SpMember body, @PathVariable Integer id) {
		body.setId(id);
		this.spMemberService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/member/{id}")
	public ResponseEntity<String> deleteSpMember(@PathVariable Integer id) {
		SpMember entity = this.spMemberService.findById(id);
		if (entity == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Member Not Found");
		}
		String result = this.spMemberService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * SpJob API
	 ******************************************************************/

	@GetMapping(value = "/sp-job/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Jobs", notes = "The Api Returns List of Jobs for a service provider", response = SpJob.class)
	public ResponseEntity<List<SpJob>> findAllSpJobs(@PathVariable Integer spId) {
		List<SpJob> lst = this.spJobService.findBySpId(spId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/job/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return one Job", notes = "The Api Returns a job for a service provider", response = SpJob.class)
	public ResponseEntity<SpJob> findSpJobById(@PathVariable Integer id) {
		SpJob entity = this.spJobService.findById(id);
		if (entity == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/job", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpJob> createSpJob(@RequestBody SpJob entity) {
		SpJob body = this.spJobService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/job/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SpJob> updateSpJob(@RequestBody SpJob body, @PathVariable Integer id) {
		body.setId(id);
		this.spJobService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/job/{id}")
	public ResponseEntity<String> deleteSpJob(@PathVariable Integer id) {
		SpJob entity = this.spJobService.findById(id);
		if (entity == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Member Not Found");
		}
		String result = this.spJobService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * SlTeam API
	 ******************************************************************/
	@GetMapping(value = "/sl-team/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Teams", notes = "The Api Returns List of Teams for a service provider", response = SlTeam.class)
	public ResponseEntity<List<SlTeam>> findAllSlTeam(@PathVariable Integer spId) {
		List<SlTeam> lst = this.slTeamService.findBySpId(spId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/team/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "return one Team", notes = "The Api Returns a Team for a service provider", response = SlTeam.class)
	public ResponseEntity<SlTeam> findSlTeamById(@PathVariable Integer id) {
		SlTeam entity = this.slTeamService.findById(id);
		if (entity == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/team", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SlTeam> createSlTeam(@RequestBody SlTeam entity) {
		SlTeam body = this.slTeamService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/team/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SlTeam> updateSlTeam(@RequestBody SlTeam body, @PathVariable Integer id) {
		body.setId(id);
		this.slTeamService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/team/{id}")
	public ResponseEntity<String> deleteSlTeam(@PathVariable Integer id) {
		SlTeam entity = this.slTeamService.findById(id);
		if (entity == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Member Not Found");
		}
		String result = this.slTeamService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * SL Order API
	 ******************************************************************/
	// get list of orders by sp id
	@GetMapping(value = "/sl-order/sp/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Orders", notes = "The Api Returns List of Orders for a service provider", response = SlOrder.class)
	public ResponseEntity<List<SlOrder>> findSlOrderForSp(@PathVariable Integer spId) {
		List<SlOrder> lst = this.slOrderService.findBySpId(spId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	// get list of orders by Customer id
	@GetMapping(value = "/sl-order/customer/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Orders for a customer", notes = "The Api Returns List of Orders for a Customer", response = SlOrder.class)
	public ResponseEntity<List<SlOrder>> findSlOrderForCustomer(@PathVariable Integer customerId) {
		List<SlOrder> lst = this.slOrderService.findByCustomerId(customerId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	// get list of orders by Team id
	@GetMapping(value = "/sl-order/team/{teamId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Orders for a team", notes = "The Api Returns List of Orders for a team", response = SlOrder.class)
	public ResponseEntity<List<SlOrder>> findSlOrderForTeam(@PathVariable Integer teamId) {
		List<SlOrder> lst = this.slOrderService.findByTeamId(teamId);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	// get list of orders by spId and order status
	@GetMapping(value = "/sl-order/sp/{spId}/{ordStatus}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Orders for a SP", notes = "The Api Returns List of Orders for a Service provider with passed status", response = SlOrder.class)
	public ResponseEntity<List<SlOrder>> findSlOrderByStatusForSp(@PathVariable Integer spId,
			@PathVariable String ordStatus) {
		List<SlOrder> lst = this.slOrderService.findByOrdStatus(spId, ordStatus);
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/sl-order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Orders for a SP", notes = "The Api Returns List of Orders for a Service provider with passed status", response = SlOrder.class)
	public ResponseEntity<SlOrder> findOrderById(@PathVariable Integer id) {
		SlOrder body = slOrderService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	@PostMapping(value = "/sl-order", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SlOrder> createSlOrder(@RequestBody SlOrder entity) {
		SlOrder body = this.slOrderService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/sl-order/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SlOrder> updateSlOrder(@RequestBody SlOrder body, @PathVariable Integer id) {
		body.setId(id);
		this.slOrderService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/sl-order/{id}")
	public ResponseEntity<String> deleteSlOrder(@PathVariable Integer id) {
		SlOrder entity = this.slOrderService.findById(id);
		if (entity == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Member Not Found");
		}
		String result = this.slOrderService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
