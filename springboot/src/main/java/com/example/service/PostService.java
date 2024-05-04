package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Post;
import com.example.mapper.PostMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {

    @Resource
    private PostMapper postMapper;

    public void add(Post post) {
        post.setCreateTime(DateUtil.now());
        postMapper.insert(post);
    }

    public List<Post> selectAll(Post post) {
        return postMapper.selectAll(post);
    }

    public PageInfo<Post> selectPage(Post post,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.selectAll(post);
        return PageInfo.of(posts);
    }

    public Post selectById(Integer postId) {
        return postMapper.selectById(postId);
    }

    public void updateCount(Integer id) {
        postMapper.updateCount(id);
    }
}
