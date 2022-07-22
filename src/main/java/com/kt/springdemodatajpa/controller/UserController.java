package com.kt.springdemodatajpa.controller;

import com.kt.springdemodatajpa.domain.UserInfo;
import com.kt.springdemodatajpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userInfos")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping("/new")
    public String createForm() {
        return "users/createUserForm";
    }

    @PostMapping("/new")
    public String createUser(UserForm form) {
        log.info(form.toString());

        UserInfo userInfo = new UserInfo();

        userInfo.setUserId(form.getUserId());
        userInfo.setPassword(form.getPassword());
        userInfo.setEmail(form.getEmail());
        userInfo.setAge(form.getAge());

        userService.join(userInfo);

        return "redirect:/userInfos"; // userInfo로.
    }

    @GetMapping
    public String list(Model model) {
        List<UserInfo> userInfos = userService.findUsers();

        model.addAttribute("userInfos", userInfos);
        return "users/userList";
    }
}
