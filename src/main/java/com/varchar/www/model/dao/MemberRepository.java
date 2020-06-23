package com.varchar.www.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varchar.www.model.domain.user.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	Optional<Member> findById(String id);
}
