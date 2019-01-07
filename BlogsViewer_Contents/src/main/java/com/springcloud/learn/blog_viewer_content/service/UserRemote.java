package com.springcloud.learn.blog_viewer_content.service;

//import com.springcloud.learn.blog_viewer_content.service.impl.UserRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name="blog-viewer-user")//,fallback = UserRemoteHystrix.class
public interface UserRemote {
    @RequestMapping("/findByUsername")
    String findByUsername(@RequestParam(value = "name") String name);
}
