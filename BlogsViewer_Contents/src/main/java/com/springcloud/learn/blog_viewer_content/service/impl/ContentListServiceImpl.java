package com.springcloud.learn.blog_viewer_content.service.impl;

import com.springcloud.learn.blog_viewer_content.entity.Blog;
import com.springcloud.learn.blog_viewer_content.mapper.BlogMapper;
import com.springcloud.learn.blog_viewer_content.service.ContentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentListServiceImpl implements ContentListService {

    @Autowired
    private BlogMapper dao;

    @Override
    public List<Blog> contentList() {

        return dao.list();
    }
}
