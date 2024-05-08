package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Likes;
import com.example.entity.News;
import com.example.mapper.NewsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资讯信息表业务处理
 **/
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private LikeService likeService;

    /**
     * 新增
     */
    public void add(News news) {
        news.setTime(DateUtil.now());
        newsMapper.insert(news);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        newsMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            newsMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(News news) {
        newsMapper.updateById(news);
    }

    /**
     * 根据ID查询
     */
    public News selectById(Integer id,Integer userId) {
        News news = newsMapper.selectById(id);
        Likes likes = likeService.selectByNews(userId, news.getId());
        if (likes == null){
            news.setLikes("未点赞");
        }else {
            news.setLikes("已点赞");
        }
        return news;
    }

    /**
     * 查询所有
     */
    public List<News> selectAll(News news) {
        return newsMapper.selectAll(news);
    }

    /**
     * 分页查询
     */
    public PageInfo<News> selectPage(News news, Integer pageNum, Integer pageSize,Integer userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsMapper.selectAll(news);
        for (News news1 : list) {
            if (likeService.selectByNews(userId,news1.getId()) != null){
                news1.setLikes("已点赞");
            }else {
                news1.setLikes("未点赞");
            }
        }
        return PageInfo.of(list);
    }

    public List<News> selectTopNews(String sort) {
        return newsMapper.selectTopNews(sort);
    }

    public void updateCount(Integer id) {
        newsMapper.updateCount(id);
    }
}