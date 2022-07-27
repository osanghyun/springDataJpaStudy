package com.kt.springdemodatajpa.controller;

import com.kt.springdemodatajpa.dto.UserDto;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/new")
    public String createForm() {
        return "users/create";
    }

    @PostMapping("/new")
    public String createUser(UserDto userDto) {

        userService.join(userDto); // save user

        return "redirect:/users/list"; // users로.
    }

    @GetMapping
    public String list(Model model) {
        List<UserDto> userDtoList = userService.getUsers();

        model.addAttribute("userList", userDtoList);
        return "users/list";
    }
}
