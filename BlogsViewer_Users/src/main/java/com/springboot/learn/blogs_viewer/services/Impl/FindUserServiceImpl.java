package com.springboot.learn.blogs_viewer.services.Impl;

import com.springboot.learn.blogs_viewer.entity.User;
import com.springboot.learn.blogs_viewer.mapper.UserMapper;
import com.springboot.learn.blogs_viewer.services.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserServiceImpl implements FindUserService {

    @Autowired
    private UserMapper dao;

    public User findById(int id){
        return dao.selectByPrimaryKey(id);
    }
    public User findByName(String name){
        return dao.selectByUsername(name);
    }
}
