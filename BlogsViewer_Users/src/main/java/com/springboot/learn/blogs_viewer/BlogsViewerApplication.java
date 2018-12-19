package com.springboot.learn.blogs_viewer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.springboot.learn.blogs_viewer.mapper")
@EnableDiscoveryClient
public class BlogsViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsViewerApplication.class, args);
    }

}

