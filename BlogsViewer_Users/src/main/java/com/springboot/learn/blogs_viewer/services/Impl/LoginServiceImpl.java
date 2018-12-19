package com.springboot.learn.blogs_viewer.services.Impl;

import com.springboot.learn.blogs_viewer.entity.User;
import com.springboot.learn.blogs_viewer.mapper.UserMapper;
import com.springboot.learn.blogs_viewer.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        //根据用户名查询用户，判断密码
        User user =  userMapper.selectByUsername(username);
        if(user==null){
            return "false";
        }else{
            if(user.getPassword().equals(password))
                return "true";
            else return "false";
        }
    }
}
