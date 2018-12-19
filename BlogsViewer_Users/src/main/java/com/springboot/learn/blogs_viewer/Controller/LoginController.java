package com.springboot.learn.blogs_viewer.Controller;

import com.springboot.learn.blogs_viewer.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("/login")
    public String login(String username,String password){
        return service.login(username,password);
    }
}
