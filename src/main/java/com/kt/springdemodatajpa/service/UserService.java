package com.kt.springdemodatajpa.service;

import com.kt.springdemodatajpa.domain.UserEntity;
import com.kt.springdemodatajpa.dto.UserDto;
import com.kt.springdemodatajpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public Long join(UserDto userDto) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(userDto.getUserId());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setAge(userDto.getAge());

        validateDuplicateUser(userEntity); // 중복 회원 검증.
        var savedUser = userRepository.save(userEntity);
        return savedUser.getIndex();
    }

    private void validateDuplicateUser(UserEntity userEntity) {
        userRepository.findByUserId(userEntity.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 회원 정보 수정. Update
     */




    /**
     * 전체 회원 조회.
     */
    public List<UserDto> getUsers() {

        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());

    }

}
