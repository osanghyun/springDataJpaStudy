package com.kt.springdemodatajpa.controller;

import com.kt.springdemodatajpa.dto.RequestUserDto;
import com.kt.springdemodatajpa.dto.ResponseUserDto;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/new")
    public String createForm() {
        return "user/create";
    }

    @PostMapping("/new")
    public String createUser(RequestUserDto requestUserDto) {

        userService.join(requestUserDto); // save user

        return "redirect:/user/list"; // user list로.
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        List<ResponseUserDto> responseUserDtoList = userService.getUsers();

        model.addAttribute("userList", responseUserDtoList);
        return "user/list";
    }
}
