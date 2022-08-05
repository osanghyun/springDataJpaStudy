package com.kt.springdemodatajpa.service;

import com.kt.springdemodatajpa.domain.Member;
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
     * 회원가입
     * @param requestUserDto : 유저 정보
     */
    public void join(RequestUserDto requestUserDto) {

        Member member = new Member();

        member.create(
                requestUserDto.getUserId(),
                requestUserDto.getPassword(),
                requestUserDto.getEmail(),
                requestUserDto.getAge()
        );

        validateDuplicateUser(member); // 중복 회원 검증.

        userRepository.save(member);
    }

    private void validateDuplicateUser(Member member) {
        userRepository.findByUserId(member.getUserId())
                .ifPresent(m -> {
                    throw new CustomException(ErrorCode.DUPLICATED_USER);
                });
    }


    /**
     * 전체 회원 조회.
     * @return 유저 목록
     */
    public List<ResponseUserDto> getUsers() {
        return userRepository.findAll().stream().map(ResponseUserDto::new).collect(Collectors.toList());
    }

    /**
     * 회원 조회
     * @param userId : 유저 아이디 값
     * @return 유저
     */
    public ResponseUserDto getUser(String userId) {
        Member member = userRepository.findByUserId(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return new ResponseUserDto(member);
    }

    /**
     * 회원 업데이트.
     * @param requestUserDto : 변경 요청 유저 정보
     * @return 변경된 유저 정보
     */
    public ResponseUserDto updateUser(RequestUserDto requestUserDto) {
        Member member = userRepository.findByUserId(requestUserDto.getUserId()).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND));

        member.update(
                requestUserDto.getPassword(),
                requestUserDto.getEmail(),
                requestUserDto.getAge()
        );

        userRepository.save(member); // 중복이있으면 자동적으로 업데이트
        return new ResponseUserDto(member);
    }

    /**
     * 회원 삭제.
     * @param userId : 타겟 유저 아이디.
     */
    public void deleteUser(String userId) {
        Member member = userRepository.findByUserId(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND));

        userRepository.delete(member);
    }

    /**
     * 전체 회원 삭제.
     */
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
