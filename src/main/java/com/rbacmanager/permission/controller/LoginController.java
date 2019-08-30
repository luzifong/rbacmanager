package com.rbacmanager.permission.controller;

import com.rbacmanager.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public String login(String username, String password) {
        if (username == "超级管理员" || username.equals("超级管理员")){
            if (password == "123123" || password.equals("123123"))
            return "redirect:/users";
        }
        return null;
    }
}
