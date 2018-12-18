package com.springcloud.learn.blog_viewer_content.service.impl;

import com.springcloud.learn.blog_viewer_content.service.UserRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserRemoteHystrix implements UserRemote {

    @Override
    public String findByUsername(@RequestParam(value = "name") String name) {
        return "熔断啦";
    }
}
