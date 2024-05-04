package com.example.controller;

import com.example.common.Result;
import com.example.entity.Likes;
import com.example.service.LikeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Resource
    private LikeService likeService;

    @PostMapping("/add")
    public Result add(@RequestBody Likes like){
        likeService.add(like);
        return Result.success();
    }
}
