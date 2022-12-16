package com.ran.final1.controller;

import com.ran.final1.domain.Users;
import com.ran.final1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/getUserList")
    @ResponseBody
    List<Users> getUserList(){
        return userService.queryAllUsers();
    }

}
