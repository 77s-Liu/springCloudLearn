package com.springcloud.learn.blog_viewer_content.service;

import com.springcloud.learn.blog_viewer_content.entity.Node;

import java.util.List;

public interface TreeViewService {
    public List<Node> getNodeList();
}
