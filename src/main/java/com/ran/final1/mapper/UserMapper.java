package com.ran.final1.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.ran.final1.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserAccount(@Param("userAccount")String userAccount);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
