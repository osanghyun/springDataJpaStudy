package com.kt.springdemodatajpa.service;

import com.kt.springdemodatajpa.domain.UserEntity;
import com.kt.springdemodatajpa.dto.RequestUserDto;
import com.kt.springdemodatajpa.dto.ResponseUserDto;
import com.kt.springdemodatajpa.exception.CustomException;
import com.kt.springdemodatajpa.exception.ErrorCode;
import com.kt.springdemodatajpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입. Create.
     */
    public void join(RequestUserDto requestUserDto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(requestUserDto.getUserId());
        userEntity.setPassword(requestUserDto.getPassword());
        userEntity.setEmail(requestUserDto.getEmail());
        userEntity.setAge(requestUserDto.getAge());

        validateDuplicateUser(userEntity); // 중복 회원 검증.

        userRepository.save(userEntity);
    }

    private void validateDuplicateUser(UserEntity userEntity) {
        userRepository.findByUserId(userEntity.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /**
     * 전체 회원 조회.
     */
    public List<ResponseUserDto> getUsers() {
        return userRepository.findAll().stream().map(ResponseUserDto::new).collect(Collectors.toList());
    }

    public ResponseUserDto getUser(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return new ResponseUserDto(userEntity);
    }

}
