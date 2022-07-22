package com.kt.springdemodatajpa.service;

import com.kt.springdemodatajpa.domain.UserInfo;
import com.kt.springdemodatajpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입.
     */
    public Long join(UserInfo userInfo) {

        validateDuplicateUser(userInfo); // 중복 회원 검증.
        var savedUser = userRepository.save(userInfo);
        return savedUser.getIndex();
    }

    private void validateDuplicateUser(UserInfo userInfo) {
        userRepository.findByUserId(userInfo.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회.
     */
    public List<UserInfo> findUsers() {
        return userRepository.findAll();
    }

    public Optional<UserInfo> findOne(Long userIndex) {
        return userRepository.findById(userIndex);
    }
}
