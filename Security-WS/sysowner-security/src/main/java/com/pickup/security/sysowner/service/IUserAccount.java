package com.pickup.security.sysowner.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;
import com.pickup.security.sysowner.model.UserExistsModel;

public interface IUserAccount extends UserDetailsService {
	public UserDto createUser(UserDto userDetails);	
	public UserDto getUserDetailsByEmail(String email);
	public UserDto getUserByUserId(String userId);
	public SysOwnerUser updateUserByUserId(UserDto userDto,String userId);
	public List<SysOwnerUser> findAll();
	public List<SysOwnerUser> findSpMembersUsers(Integer spId);
	public SysOwnerUser loadUserByCustomerId(Integer customerId);
	public SysOwnerUser changePassword(String email,String oldpassword,String newpassword);
	public UserExistsModel RestPassword(String email);
	
}
