package com.springcloud.learn.blog_viewer_content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.springcloud.learn.blog_viewer_content.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class BlogViewerContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogViewerContentApplication.class, args);
    }

}

