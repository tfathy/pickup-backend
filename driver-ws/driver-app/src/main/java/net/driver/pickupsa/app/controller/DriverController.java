package net.driver.pickupsa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import net.driver.pickupsa.app.entity.UserLogin;
import net.driver.pickupsa.app.service.UserLoginService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private UserLoginService userLoginService;

	@PostMapping(value = "/user-login-info", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create record in the sysUserLogin table to log the user login date and location and his status")
	public ResponseEntity<UserLogin> create(@RequestBody UserLogin body) {
		UserLogin entity = userLoginService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);

	}

	@PutMapping(value = "/user-login-info/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update the userlogin of a user.for example update his status")
	public ResponseEntity<UserLogin> update(@RequestBody UserLogin body, Integer id) {
		UserLogin entity = userLoginService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);

	}

}
