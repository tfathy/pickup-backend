package com.pickup.sysowner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.GnItem;

public interface GnItemRepos extends JpaRepository<GnItem, Integer> {

}
