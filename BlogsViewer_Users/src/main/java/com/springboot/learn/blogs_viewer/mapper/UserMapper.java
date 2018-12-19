package com.springboot.learn.blogs_viewer.mapper;

import com.springboot.learn.blogs_viewer.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //generator
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //manual
    User selectByUsername(String username);
}