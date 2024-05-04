package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Likes;
import com.example.mapper.LikeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LikeService {

    @Resource
    private LikeMapper likeMapper;

    public void add(Likes like) {
        like.setCreateTime(DateUtil.now());
        likeMapper.insert(like);
    }

}
