package com.ran.final1.service;

import com.ran.final1.domain.Users;
import com.ran.final1.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UsersMapper usersMapper;

    /**
     * 查询所有用户
     */
    public List<Users> queryAllUsers(){
        return usersMapper.selectAll();
    }


}
