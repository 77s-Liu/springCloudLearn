package com.springboot.learn.blogs_viewer.mapper;

import com.springboot.learn.blogs_viewer.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}