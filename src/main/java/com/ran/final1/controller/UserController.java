package com.ran.final1.controller;

import com.ran.final1.domain.User;
import com.ran.final1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",originPatterns = "*")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/getUserList")
    @ResponseBody
    List<User> getUserList(){
        return userService.queryAllUsers();
    }

    @RequestMapping("/login")
    @ResponseBody
    Map<String,String> login(@RequestBody(required = false) Map<String,String> data){
        System.out.println(data);

        String account = data.get("account");
        String password = data.get("password");
        return userService.login(account,password);
    }
}
