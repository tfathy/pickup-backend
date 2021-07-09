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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;
import com.pickup.security.sysowner.model.CreateUserRequestModel;
import com.pickup.security.sysowner.model.CreateUserResponseModel;
import com.pickup.security.sysowner.model.UserResponseModel;
import com.pickup.security.sysowner.service.IUserAccount;

@RestController
@RequestMapping("/owner-auth")
public class OwnerSecurityController {

	@Autowired
	private IUserAccount userAccountServices;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

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

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SysOwnerUser>> findAll() {
		List<SysOwnerUser> list = userAccountServices.findAll();
		if (list == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(list);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}
