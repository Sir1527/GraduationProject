package com.example.mapper;

import com.example.entity.Likes;
import com.example.entity.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PostMapper {

    int insert (Post post);

    List<Post> selectAll(Post post);

    Post selectById(Integer id);

    @Update("update post set count = count + 1 where postId = #{id}")
    void updateCount(Integer id);
}
