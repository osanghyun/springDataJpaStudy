package com.kt.springdemodatajpa.controller;


import com.kt.springdemodatajpa.dto.UserDto;
import com.kt.springdemodatajpa.model.ListResponse;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.kt.springdemodatajpa.util.CommonResponseUtil.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/list")
    public ListResponse<UserDto> getUserInfos() {
        // 요청값 처리 HttpEntity 설정 헤더 설정
        return getSuccessListResponse(userService.getUsers());
    }
}
