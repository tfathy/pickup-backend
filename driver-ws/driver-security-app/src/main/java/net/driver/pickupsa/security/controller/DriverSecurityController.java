package net.driver.pickupsa.security.controller;

import org.modelmapper.ModelMapper;
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

import net.driver.pickupsa.security.entity.DriverUser;
import net.driver.pickupsa.security.model.UserDto;
import net.driver.pickupsa.security.model.UserResponseModel;
import net.driver.pickupsa.security.service.IUserAccount;

@RestController
@RequestMapping("/driver-auth")
public class DriverSecurityController {

	@Autowired
	private IUserAccount userAccountServices;

	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) {

		UserDto userDto = userAccountServices.getUserByUserId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}

	@PutMapping(value = "/change-pw/{email}/{oldpassword}/{newpassword}", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DriverUser> changePassword(@RequestBody DriverUser entity, @PathVariable String email,
			@PathVariable String oldpassword, @PathVariable String newpassword) {
		DriverUser e = this.userAccountServices.changePassword(email, oldpassword, newpassword);
		if (e == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}

}
