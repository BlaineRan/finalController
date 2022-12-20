package com.ran.final1.controller;

import com.ran.final1.domain.User;
import com.ran.final1.service.UserService;
import com.ran.final1.util.RanUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",originPatterns = "*")
public class UserController {
    @Autowired
    public UserService userService;

    /**
     *  Author:Ran
     *  Description:GET 查询所有用户
     *  CreateDate: 2022/12/17
     *  LastModifyDate: 2022/12/19
     *  URL: /user/getUserList
     * */
    @RequestMapping("/getUserList")
    @ResponseBody
    List<User> getUserList(){
        return userService.queryAllUsers();
    }

    /**
     *  Author:Ran
     *  Description:POST 登录接口
     *  Input: account:账号; password:密码;
     *  CreateDate: 2022/12/17
     *  LastModifyDate: 2022/12/20
     *  URL: /user/login
     * */
    @RequestMapping("/login")
    @ResponseBody
    Map<String,String> login(@RequestBody(required = false) Map<String,String> data){
        System.out.println(data);

        String account = data.get("account");
        String password = data.get("password");
        Map<String,String> loginResult = userService.login(account,password);
        if(loginResult == null){
            loginResult = new HashMap<>();
            loginResult.put("status","error");
        }
        return loginResult;
    }

    /**
     *  Author:Ran
     *  Description:POST 根据jwt token查询当前用户
     *  Input: token:token
     *  CreateDate: 2022/12/20
     *  LastModifyDate: 2022/12/20
     *  URL: /user/currentUser
     * */
    @RequestMapping("/currentUser")
    @ResponseBody
    Map<String,String> currentUser(@RequestBody(required = false) Map<String,String> tokenMap){
        Map<String,String> map = new HashMap<>();
        String token = tokenMap.get("token");
        return userService.currentUser(token);
    }

}
