package com.ran.final1.service;

import com.ran.final1.domain.User;
import com.ran.final1.mapper.UserMapper;
import com.ran.final1.util.RanUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    /**
     * 查询所有用户
     */
    public List<User> queryAllUsers(){
        return userMapper.selectAll();
    }

    public User queryUserByAccount(String account){
        return userMapper.selectByUserAccount(account);
    }

    /**
     * 登录 返回登录状态、权限、token
     */
    public Map<String,String> login(String account,String password){
        Map<String,String> loginResult = new HashMap<>();
        User user = userMapper.selectByUserAccount(account);
        if(user != null){
            if(user.getUserPassword().equals(password)){
                Map<String,String> tokenMap = new HashMap<>();
                tokenMap.put("account", user.getUserAccount());
                tokenMap.put("access", user.getUserType());
                String token = RanUtil
                        .jwtGenerate(tokenMap,1);
                loginResult.put("status","ok");
                loginResult.put("type",user.getUserType());
                loginResult.put("token",token);
            }else{
                loginResult.put("status","error");
            }
        }else{
            loginResult.put("status","error");
        }
        return loginResult;
    }

    public Map<String,String> currentUser(String token){
        Map<String,String> currentUser = new HashMap<>();
        Claims body = RanUtil.parse(token, RanUtil.secretKey);
        String account = body.get("account").toString();

        User user = userMapper.selectByUserAccount(account);
        currentUser.put("userAccount",account);
        currentUser.put("userName", user.getUserName());
        currentUser.put("userPassword", user.getUserPassword());
        currentUser.put("userId", user.getUserId().toString());
        currentUser.put("userSex", user.getUserSex());
        currentUser.put("userType",user.getUserType());
        currentUser.put("access",user.getUserType());

        return currentUser;
    }
}
