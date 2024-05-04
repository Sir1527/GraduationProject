package com.example.entity;

public class Post {
    private int postId;
    private int userId;
    private String userAvatar;
    private String title;
    private String cover;
    private String content;
    private String category;
    private int count;
    private String createTime;

    public Post() {
    }

    public Post(int postId, int userId, String userAvatar, String title, String cover, String content, String category, int count, String createTime) {
        this.postId = postId;
        this.userId = userId;
        this.userAvatar = userAvatar;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.category = category;
        this.count = count;
        this.createTime = createTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", userAvatar='" + userAvatar + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", count=" + count +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}