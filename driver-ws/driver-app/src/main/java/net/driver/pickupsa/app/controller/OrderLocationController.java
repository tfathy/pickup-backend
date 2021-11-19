package net.driver.pickupsa.app.controller;

import java.util.List;

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

import net.driver.pickupsa.app.entity.OrderLocation;
import net.driver.pickupsa.app.service.OrderLocationService;

@RestController
@RequestMapping("/order-location")
public class OrderLocationController {

	@Autowired
	private OrderLocationService service;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderLocation> findById(@PathVariable int id) {
		OrderLocation body = service.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);

	}
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<OrderLocation>> findAll() {
		List<OrderLocation> body = service.findAll();
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);

	}

	@PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderLocation> save(@RequestBody OrderLocation entity) {
		OrderLocation body = service.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderLocation> update(@RequestBody OrderLocation entity,Integer id) {
		OrderLocation body = service.update(entity,id);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@GetMapping(value = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<OrderLocation>> findRouteByOrderId(@PathVariable int id) {
		List<OrderLocation> lst = service.findRouteByOrderId(id);
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}
	@GetMapping(value = "/first/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderLocation> findFirstLocationForOrder(@PathVariable int id) {
		OrderLocation body = service.findFirstLocationForOrder(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	@GetMapping(value = "/last/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<OrderLocation> findByOrderId(@PathVariable int id) {
		OrderLocation body = service.findLastLocationForOrder(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
}
