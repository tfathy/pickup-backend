package com.customer.pickup.controller;

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

import com.customer.pickup.entity.Customer;
import com.customer.pickup.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> lst = customerService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> findById(@PathVariable int id) {
		Customer entity = customerService.findById(id);
		if (entity == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> create(@RequestBody Customer body) {
		Customer entity = customerService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> update( @RequestBody Customer body,@PathVariable int id) {
		Customer entity = customerService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

}
