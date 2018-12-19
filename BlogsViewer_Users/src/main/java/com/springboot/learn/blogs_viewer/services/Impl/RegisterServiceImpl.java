package com.springboot.learn.blogs_viewer.services.Impl;

import com.springboot.learn.blogs_viewer.entity.User;
import com.springboot.learn.blogs_viewer.mapper.UserMapper;
import com.springboot.learn.blogs_viewer.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        User u = userMapper.selectByUsername(user.getUsername());
        if(u!=null){
            return "false";
        }else {
            int id = userMapper.insert(user);
            return "true";
        }
    }
}
