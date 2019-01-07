package com.springcloud.learn.blog_viewer_content.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.learn.blog_viewer_content.entity.Node;
import com.springcloud.learn.blog_viewer_content.service.TreeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeViewService service;

    @RequestMapping("/view.do")
    public String view(HttpServletRequest request, HttpServletResponse response){
        return "treeview";
    }

    @RequestMapping("/view_jQuery.do")
    public String view_j(HttpServletRequest request, HttpServletResponse response){
        return "treeview_jQuery";
    }

    @RequestMapping(value="/treeView.do",method = RequestMethod.GET)
    @ResponseBody
    public String tree(HttpServletRequest request,HttpServletResponse response){
        List<Node> list = service.getNodeList();
        return JSON.toJSONString(list);
    }
}
