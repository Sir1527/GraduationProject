package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Likes;
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
    @Resource
    private LikeService likeService;

    public void add(Post post) {
        post.setCreateTime(DateUtil.now());
        postMapper.insert(post);
    }

    public List<Post> selectAll(Post post) {
        return postMapper.selectAll(post);
    }

    public PageInfo<Post> selectPage(Post post,Integer pageNum,Integer pageSize,Integer userId){
        PageHelper.startPage(pageNum,pageSize);
        List<Post> posts = postMapper.selectAll(post);
        for (Post post1 : posts) {
            if (likeService.selectByPost(userId,post1.getPostId()) != null){
                post1.setIsLike("已点赞");
            }else {
                post1.setIsLike("未点赞");
            }
        }
        return PageInfo.of(posts);
    }

    public Post selectById(Integer postId, Integer userId) {
        Post post = postMapper.selectById(postId);
        Likes likes = likeService.selectByPost(userId, post.getPostId());
        if (likes == null){
            post.setIsLike("未点赞");
        }else {
            post.setIsLike("已点赞");
        }
        return post;
    }

    public void updateCount(Integer id) {
        postMapper.updateCount(id);
    }
}
