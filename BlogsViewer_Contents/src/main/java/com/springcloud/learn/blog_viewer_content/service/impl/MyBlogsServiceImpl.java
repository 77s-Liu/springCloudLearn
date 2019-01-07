package com.springcloud.learn.blog_viewer_content.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.learn.blog_viewer_content.entity.Blog;
import com.springcloud.learn.blog_viewer_content.entity.User;
import com.springcloud.learn.blog_viewer_content.mapper.BlogMapper;
import com.springcloud.learn.blog_viewer_content.service.MyBlogsService;
import com.springcloud.learn.blog_viewer_content.service.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyBlogsServiceImpl implements MyBlogsService {

    @Autowired
    private BlogMapper dao;
    @Autowired
    private UserRemote userRemote;

    @Override
    @HystrixCommand(fallbackMethod = "fail")
    public List<Blog> listMyBlogs(String name) {

        System.out.println("啦啦啦啦");
        String userJson = userRemote.findByUsername(name);
        if(userJson.equals("熔断啦")){
            return null;
        }
        User user = JSON.parseObject(userJson,new TypeReference<User>(){});
        List<Blog> myList = dao.listByAuthorId(user.getId());
        return myList;
    }

    /**
     * 熔断方法，参数名与返回值名要与listMyBlogs一致
     * @param name
     * @return
     */
    public List<Blog> fail(String name){
        System.out.println("我是熔断fallback方法");
        return new ArrayList<Blog>();
    }

}
