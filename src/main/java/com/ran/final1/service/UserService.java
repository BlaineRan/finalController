package com.ran.final1.service;

import com.ran.final1.domain.User;
import com.ran.final1.mapper.UserMapper;
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
        return userMapper.selectByUserAccount(account).get(0);
    }

    public Map<String,String> login(String account,String password){
        Map<String,String> loginResult = new HashMap<>();
        List<User> userList = userMapper.selectByUserAccount(account);
        User user = null;
        if(userList.size() != 0){
            user = userList.get(0);
        }
        if(user != null){
            if(user.getUserPassword().equals(password)){
                loginResult.put("status","ok");
                loginResult.put("type",user.getUserType());
            }else{
                loginResult.put("status","error");
            }
        }else{
            loginResult.put("status","error");
        }
        return loginResult;
    }
}
