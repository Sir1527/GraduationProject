package com.example.entity;

public class Reminder {
    private Integer reminderId;
    private Integer userId;
    private String reminderTime;
    private String title;
    private String createTime;

    public Reminder() {
    }

    public Reminder(Integer reminderId, Integer userId, String reminderTime, String title, String createTime) {
        this.reminderId = reminderId;
        this.userId = userId;
        this.reminderTime = reminderTime;
        this.title = title;
        this.createTime = createTime;
    }

    public Integer getReminderId() {
        return reminderId;
    }

    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "reminderId=" + reminderId +
                ", userId=" + userId +
                ", reminderTime='" + reminderTime + '\'' +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
