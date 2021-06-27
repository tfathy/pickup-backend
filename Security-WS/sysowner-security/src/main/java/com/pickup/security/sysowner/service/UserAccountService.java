package com.pickup.security.sysowner.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pickup.security.sysowner.entity.SysOwnerUser;
import com.pickup.security.sysowner.entity.shared.UserDto;
import com.pickup.security.sysowner.repos.UserRepos;

@Service
public class UserAccountService implements IUserAccount {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	BCryptPasswordEncoder encoder;
	UserRepos userRepos;

	@Autowired
	public UserAccountService(UserRepos repos, BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
		this.userRepos = repos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysOwnerUser userEntity = userRepos.findByEmail(username);

		if (userEntity == null)
			throw new UsernameNotFoundException(username);
		System.out.println(">>> returned user in loadUserByUsername *******************************");
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getEncryptedPassword());
		System.out.println(userEntity.getId());
		System.out.println(userEntity.getHrEmployee());
		System.out.println("*************************************************************************");

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(encoder.encode(userDetails.getPassword()));

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		SysOwnerUser userEntity = modelMapper.map(userDetails, SysOwnerUser.class);

		userRepos.save(userEntity);

		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

		return returnValue;
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		SysOwnerUser userEntity = userRepos.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		SysOwnerUser userEntity = userRepos.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException("User not found");
		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		return userDto;
	}

}
