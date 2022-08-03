package com.kt.springdemodatajpa.controller;


import com.kt.springdemodatajpa.dto.RequestUserDto;
import com.kt.springdemodatajpa.dto.ResponseUserDto;
import com.kt.springdemodatajpa.model.ListResponse;
import com.kt.springdemodatajpa.model.SingleResponse;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.kt.springdemodatajpa.util.CommonResponseUtil.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/list")
    public ListResponse<ResponseUserDto> getUsers() {
        // 요청값 처리 HttpEntity 설정 헤더 설정
        return getSuccessListResponse(userService.getUsers());
    }


    /**
     * todo : find, save, delete 이용해서 API와 연동.
     */
    @GetMapping("{userId}")
    public SingleResponse<ResponseUserDto> getUser(@PathVariable String userId) {
        return getSuccessSingleResponse(userService.getUser(userId));
    }
}
