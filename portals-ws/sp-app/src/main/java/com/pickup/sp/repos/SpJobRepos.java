package com.pickup.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sp.entity.SpJob;

public interface SpJobRepos extends JpaRepository<SpJob, Integer> {

}
