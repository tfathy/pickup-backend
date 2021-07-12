package com.pickup.sysowner.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnItemCategory;

public interface GnItemRepos extends JpaRepository<GnItem, Integer> {
	public List<GnItem> findByGnItemCategory(GnItemCategory gnItemCategory);

}
