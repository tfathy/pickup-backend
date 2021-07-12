package com.pickup.sysowner.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.GnItemService;

public interface GnItemServiceRepos extends JpaRepository<GnItemService, Integer> {
			public List<GnItemService> findByItemId(Integer itemId);
}
