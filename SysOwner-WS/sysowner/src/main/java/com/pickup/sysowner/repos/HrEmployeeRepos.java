package com.pickup.sysowner.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sysowner.entity.HrEmployee;

public interface HrEmployeeRepos extends JpaRepository<HrEmployee, Integer> {

}
