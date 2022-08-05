package com.kt.springdemodatajpa.repository;

import com.kt.springdemodatajpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);
}
