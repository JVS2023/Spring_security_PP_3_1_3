package com.example.spring_security.controller;

import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String oneUserPage(Principal principal, Model model) {
        User user = userService.findUsersByEmail(principal.getName());
        model.addAttribute("usera", user);
        return "user";
    }
}
