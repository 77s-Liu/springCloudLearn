package com.springcloud.learn.blog_viewer_content.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.learn.blog_viewer_content.entity.Blog;
import com.springcloud.learn.blog_viewer_content.service.ContentListService;
import com.springcloud.learn.blog_viewer_content.service.MyBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {

    @Autowired
    private ContentListService service;
    @Autowired
    private MyBlogsService myService;
    /**
     * 获取所有blog列表
     * @return
     */
    @RequestMapping("/list")
    public String list(){
        List<Blog> list = service.contentList();
        return JSON.toJSONString(list);
    }

    @RequestMapping("/myList")
    public String myList(String name){
        List<Blog> list = myService.listMyBlogs(name);
        return JSON.toJSONString(list);
    }
}
