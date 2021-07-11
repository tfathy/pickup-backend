package com.pickup.security.sysowner.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;

public interface IUserAccount extends UserDetailsService {
	public UserDto createUser(UserDto userDetails);	
	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
	public List<SysOwnerUser> findAll();
	public SysOwnerUser changePassword(String email,String oldpassword,String newpassword);
}
