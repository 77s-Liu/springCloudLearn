package com.springcloud.learn.blog_viewer_content.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.springcloud.learn.blog_viewer_content.entity.Blog;
import com.springcloud.learn.blog_viewer_content.entity.User;
import com.springcloud.learn.blog_viewer_content.mapper.BlogMapper;
import com.springcloud.learn.blog_viewer_content.service.MyBlogsService;
import com.springcloud.learn.blog_viewer_content.service.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyBlogsServiceImpl implements MyBlogsService {

    @Autowired
    private BlogMapper dao;
    @Autowired
    private UserRemote userRemote;

    @Override
    public List<Blog> listMyBlogs(String name) {

        String userJson = userRemote.findByUsername(name);
        if(userJson.equals("熔断啦")){
            return null;
        }
        User user = JSON.parseObject(userJson,new TypeReference<User>(){});
        List<Blog> myList = dao.listByAuthorId(user.getId());
        return myList;
    }

}
