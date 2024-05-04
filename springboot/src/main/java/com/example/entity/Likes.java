package com.example.entity;

public class Likes {
    private int likeId;
    private int userId;
    private int newsId;
    private int postId;
    private int commentId;
    private String createTime;

    public Likes() {
    }

    public Likes(int likeId, int userId, int newsId, int postId, int commentId, String createTime) {
        this.likeId = likeId;
        this.userId = userId;
        this.newsId = newsId;
        this.postId = postId;
        this.commentId = commentId;
        this.createTime = createTime;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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
                ", commentId=" + commentId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
