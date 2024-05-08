package com.example.controller;

import com.example.common.Result;
import com.example.entity.Post;
import com.example.service.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @PostMapping("/add")
    public Result add(@RequestBody Post post){
        postService.add(post);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Post post){
        List<Post> list = postService.selectAll(post);
        return Result.success(list);
    }

    @GetMapping("/selectPage")
    public Result selectPage(Post post,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "0") Integer userId){
        PageInfo<Post> postPageInfo = postService.selectPage(post, pageNum, pageSize,userId);
        return Result.success(postPageInfo);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id,
                             @RequestParam(defaultValue = "0") Integer userId){
        Post post = postService.selectById(id,userId);
        return Result.success(post);
    }

    @PutMapping("/updateCount/{id}")
    public Result updateCount(@PathVariable Integer id){
        postService.updateCount(id);
        return Result.success();
    }

}
