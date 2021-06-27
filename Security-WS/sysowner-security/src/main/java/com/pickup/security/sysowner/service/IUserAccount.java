package com.pickup.security.sysowner.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pickup.security.sysowner.entity.shared.UserDto;

public interface IUserAccount extends UserDetailsService {
	public UserDto createUser(UserDto userDetails);	
	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
}
