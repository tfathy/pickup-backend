package com.pickup.security.sysowner.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;
import com.pickup.security.sysowner.model.CreateUserRequestModel;
import com.pickup.security.sysowner.model.CreateUserResponseModel;
import com.pickup.security.sysowner.model.CustomerUserResponseModel;
import com.pickup.security.sysowner.model.UserExistsModel;
import com.pickup.security.sysowner.model.UserResponseModel;
import com.pickup.security.sysowner.service.IUserAccount;

@RestController
@RequestMapping("/owner-auth")
public class OwnerSecurityController {

	@Autowired
	private IUserAccount userAccountServices;

	@PostMapping(value = "/check/user", consumes = { MediaType.TEXT_PLAIN_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserExistsModel> checkUserNameFound(@RequestBody String email) {
		UserExistsModel result = userAccountServices.RestPassword(email);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails) {
		System.out.println("Request commig from the client is: userDetails=");
		System.out.println(userDetails);
		System.out.println("***********************1****************");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		System.out.println("userDto is :");
		System.out.println(userDto);
		System.out.println("***********************2****************");

		UserDto createdUser = userAccountServices.createUser(userDto);

		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	@PostMapping(value = "/customer", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createcUSTOMERuSER(@RequestBody CreateUserRequestModel userDetails) {
		System.out.println("Request commig from the client is: userDetails=");
		System.out.println(userDetails);
		System.out.println("***********************1****************");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		System.out.println("userDto is :");
		System.out.println(userDto);
		System.out.println("***********************2****************");

		UserDto createdUser = userAccountServices.createUser(userDto);

		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) {

		UserDto userDto = userAccountServices.getUserByUserId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	@GetMapping(value = "/customer/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerUserResponseModel> getCustomerUser(@PathVariable("userId") String userId) {

		UserDto userDto = userAccountServices.getUserByUserId(userId);
		CustomerUserResponseModel returnValue = new ModelMapper().map(userDto, CustomerUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	// to return the user information by customer id-- this method is used in the driver app to return the fcmtoken of the customer
	@GetMapping(value="/user/{customerId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysOwnerUser> getUserByCustomerId(@PathVariable("customerId") Integer customerId){
		SysOwnerUser entity = userAccountServices.loadUserByCustomerId(customerId);
		if(entity==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@GetMapping(value="/user/member/{memberId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysOwnerUser> findUserByMemberId(@PathVariable("memberId") Integer memberId){
		SysOwnerUser entity = userAccountServices.findByMemberId(memberId);
		if(entity==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	// to update user data
	@PutMapping(value = "/update/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> updateUser(@RequestBody UserDto model,
			@PathVariable("userId") String userId) {

		SysOwnerUser sysuser = userAccountServices.updateUserByUserId(model, userId);
		UserResponseModel returnValue = new ModelMapper().map(sysuser, UserResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SysOwnerUser>> findAll() {
		List<SysOwnerUser> list = userAccountServices.findAll();
		if (list == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@PutMapping(value = "/change-pw/{email}/{oldpassword}/{newpassword}", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SysOwnerUser> changePassword(@RequestBody SysOwnerUser entity, @PathVariable String email,
			@PathVariable String oldpassword, @PathVariable String newpassword) {
		SysOwnerUser e = this.userAccountServices.changePassword(email, oldpassword, newpassword);
		if (e == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}

	@GetMapping(value = "/members-account/{spId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SysOwnerUser>> findAllSpMembersUsers(@PathVariable Integer spId) {
		List<SysOwnerUser> list = this.userAccountServices.findSpMembersUsers(spId);
		if (list == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
