package com.pickup.security.sysowner.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pickup.security.sysowner.entity.SysOwnerUser;
@Repository
public interface UserRepos extends JpaRepository<SysOwnerUser, Integer> {

	SysOwnerUser findByEmail(String email);

	SysOwnerUser findByUserId(String userId);
	
	SysOwnerUser findById(int id);
}
