package com.pickup.sysowner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.SysOwner;

public interface SysOwnerRepos extends JpaRepository<SysOwner, Integer> {

}
