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
import com.customer.pickup.entity.SlOrder;
import com.customer.pickup.services.CustomerService;
import com.customer.pickup.services.SlOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SlOrderService orderService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of Customers", notes = "The Api Returns List of Customers", response = Customer.class)
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> lst = customerService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "A Customer information", notes = "The Api Returns a customer by hid id", response = Customer.class)
	public ResponseEntity<Customer> findById(@PathVariable int id) {
		Customer entity = customerService.findById(id);
		if (entity == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create new record in the customer table", notes = "The Api used to create a customer", response = Customer.class)
	public ResponseEntity<Customer> create(@RequestBody Customer body) {
		Customer entity = customerService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> update(@RequestBody Customer body, @PathVariable int id) {
		Customer entity = customerService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	/*
	 * *****************************************************************************
	 * ******************** SlOrder Services
	 * *****************************************************************************
	 * ********************
	 */

	@GetMapping(value = "/order/customer/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "This api return a list if orders for a given customer id")
	public ResponseEntity<List<SlOrder>> findOrderByCustomerId(@PathVariable int customerId) {
		List<SlOrder> entityList = orderService.findByCustomerId(customerId);
		if (entityList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entityList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entityList);
	}
	
	@GetMapping(value = "/order/status/{customerId}/{ordStatus}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "This api return a list if orders for a given customer id and a givien order status")
	public ResponseEntity<List<SlOrder>> findOrderByCustomerAndStatus(@PathVariable int customerId, @PathVariable String ordStatus) {
		List<SlOrder> entityList = orderService.findByStatusAndCustomer(customerId,ordStatus);
		if (entityList == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entityList);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entityList);
	}

	@GetMapping(value = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "This api return an  order for a given id")
	public ResponseEntity<SlOrder> findOrderById(@PathVariable int id) {
		SlOrder entity = orderService.findById(id);
		if (entity == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/order", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "save an order")
	public ResponseEntity<SlOrder> saveOrder(@RequestBody SlOrder body) {
		SlOrder order = orderService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@PutMapping(value = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update an order of a given Id")
	public ResponseEntity<SlOrder> updateOrder(@RequestBody SlOrder body, @PathVariable int id) {
		SlOrder order = orderService.update(body, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

}
