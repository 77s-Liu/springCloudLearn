package com.springboot.learn.blogs_viewer.Controller;

import com.springboot.learn.blogs_viewer.entity.User;
import com.springboot.learn.blogs_viewer.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService service;

    @RequestMapping("/register")
    public String register(User user){
        return service.register(user);
    }
}
