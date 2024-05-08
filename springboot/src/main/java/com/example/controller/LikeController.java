package com.example.controller;

import com.example.common.Result;
import com.example.entity.Likes;
import com.example.service.LikeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/selectAll")
    public Result selectAll(Likes likes) {
        return Result.success(likeService.selectAll(likes));
    }

    @GetMapping("/selectByNews")
    public Result selectByNews(Integer userId,Integer newsId) {
        return Result.success(likeService.selectByNews(userId,newsId));
    }

    @DeleteMapping("/deleteNews")
    public Result deleteByNews(Integer userId,Integer newsId) {
        return Result.success(likeService.deleteByNews(userId,newsId));
    }

    @GetMapping("/selectByPost")
    public Result selectByPost(Integer userId,Integer postId) {
        return Result.success(likeService.selectByPost(userId,postId));
    }

    @DeleteMapping("/deletePost")
    public Result deleteByPost(Integer userId,Integer postId) {
        return Result.success(likeService.deleteByPost(userId,postId));
    }

}
