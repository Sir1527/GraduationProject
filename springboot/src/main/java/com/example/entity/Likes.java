package com.example.entity;

public class Likes {
    private Integer likeId;
    private Integer userId;
    private Integer newsId;
    private Integer postId;
    private String createTime;

    public Likes() {
    }

    public Likes(Integer likeId, Integer userId, Integer newsId, Integer postId, String createTime) {
        this.likeId = likeId;
        this.userId = userId;
        this.newsId = newsId;
        this.postId = postId;
        this.createTime = createTime;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "likeId=" + likeId +
                ", userId=" + userId +
                ", newsId=" + newsId +
                ", postId=" + postId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
