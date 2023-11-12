package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/user")
    @ResponseBody
    public String getUser() {
        return "Username: " + user.getUsername();
    }
}
