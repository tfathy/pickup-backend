package com.pickup.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickup.sp.entity.SpMember;

public interface SpMemberRepos extends JpaRepository<SpMember, Integer> {

}
