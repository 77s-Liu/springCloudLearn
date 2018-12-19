package com.springboot.learn.blogs_viewer.services;

import com.springboot.learn.blogs_viewer.entity.User;

public interface FindUserService {

    public User findById(int id);

    public User findByName(String name);
}
