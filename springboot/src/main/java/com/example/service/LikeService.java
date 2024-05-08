package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Likes;
import com.example.mapper.LikeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeService {

    @Resource
    private LikeMapper likeMapper;

    public void add(Likes like) {
        like.setCreateTime(DateUtil.now());
        likeMapper.insert(like);
    }

    public List<Likes> selectAll(Likes likes){
        return likeMapper.selectAll(likes);
    }

    public Likes selectByNews(Integer userId,Integer newsId){
        return likeMapper.selectByNews(userId, newsId);
    }

    public Likes selectByPost(Integer userId,Integer postId) { return likeMapper.selectByPost(userId,postId);}

    public int deleteByNews(Integer userId,Integer newsId){
        return likeMapper.deleteByNews(userId, newsId);
    }

    public int deleteByPost(Integer userId,Integer postId){
        return likeMapper.deleteByPost(userId, postId);
    }
}
