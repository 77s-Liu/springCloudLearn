package com.springcloud.learn.blog_viewer_content.service;

import com.springcloud.learn.blog_viewer_content.entity.Blog;

import java.util.List;

public interface MyBlogsService {
    public List<Blog> listMyBlogs(String name);
}
