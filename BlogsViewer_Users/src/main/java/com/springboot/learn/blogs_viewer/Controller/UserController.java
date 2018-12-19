package com.springboot.learn.blogs_viewer.Controller;

import com.alibaba.fastjson.JSON;
import com.springboot.learn.blogs_viewer.services.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private FindUserService service;

    @RequestMapping("/findByUsername")
    public String findByUsername(@RequestParam(value = "name") String name){
        return JSON.toJSONString(service.findByName(name));
    }
}
