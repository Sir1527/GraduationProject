package com.example.mapper;

import com.example.entity.Likes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMapper {
    int insert (Likes like);
    List<Likes> selectAll(Likes like);
    Likes selectByNews(@Param("userId")Integer userId, @Param("newsId") Integer newsId);

    int deleteByNews(@Param("userId")Integer userId, @Param("newsId") Integer newsId);

    Likes selectByPost(@Param("userId")Integer userId, @Param("postId") Integer postId);

    int deleteByPost(@Param("userId")Integer userId, @Param("postId") Integer postId);
}
