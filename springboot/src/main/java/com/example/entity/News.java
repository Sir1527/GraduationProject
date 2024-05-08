package com.example.entity;

import java.io.Serializable;

/**
 * 资讯表
 */
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;
    /** 标题 */
    private String title;
    /** 简介 */
    private String descr;
    /** 内容 */
    private String content;
    /** 封面 */
    private String cover;
    /** 发布时间 */
    private String time;
    /** 浏览次数 */
    private Integer count;
    /** 分类 */
    private String category;
    private String Likes;

    public News() {
    }

    public News(Integer id, String title, String descr, String content, String cover, String time, Integer count, String category, String likes) {
        this.id = id;
        this.title = title;
        this.descr = descr;
        this.content = content;
        this.cover = cover;
        this.time = time;
        this.count = count;
        this.category = category;
        this.Likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", time='" + time + '\'' +
                ", count=" + count +
                ", category='" + category + '\'' +
                ", Likes='" + Likes + '\'' +
                '}';
    }
}