package com.kt.springdemodatajpa.repository;

import com.kt.springdemodatajpa.domain.UserEntity;
import com.kt.springdemodatajpa.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserId(String userId);


}
