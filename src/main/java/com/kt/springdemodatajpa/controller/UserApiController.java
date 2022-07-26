package com.kt.springdemodatajpa.controller;


import com.kt.springdemodatajpa.dto.RequestUserDto;
import com.kt.springdemodatajpa.dto.ResponseUserDto;
import com.kt.springdemodatajpa.model.ListResponse;
import com.kt.springdemodatajpa.model.SingleResponse;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static com.kt.springdemodatajpa.util.CommonResponseUtil.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@Validated @RequestBody final RequestUserDto requestUserDto) {
        userService.join(requestUserDto);
    }

    @GetMapping("/list")
    public ListResponse<ResponseUserDto> getUsers() {
        // 요청값 처리 HttpEntity 설정 헤더 설정
        return getSuccessListResponse(userService.getUsers());
    }

    @GetMapping("/userId/{userId}")
    public SingleResponse<ResponseUserDto> getUser(@PathVariable String userId) {
        return getSuccessSingleResponse(userService.getUser(userId));
    }

    @PutMapping("/update")
    public SingleResponse<ResponseUserDto> updateUser(@Validated @RequestBody RequestUserDto requestUserDto) {
        return getSuccessSingleResponse(userService.updateUser(requestUserDto));
    }

    @DeleteMapping ("/delete/userId/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllUser() {
        userService.deleteAllUser();
    }
}
