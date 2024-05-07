package com.example.entity;

public class Glu {
    private Integer gluId;
    private Integer userId;
    private Float glu;
    private String createTime;

    public Glu() {
    }

    public Glu(Integer gluId, Integer userId, Float glu, String createTime) {
        this.gluId = gluId;
        this.userId = userId;
        this.glu = glu;
        this.createTime = createTime;
    }

    public Integer getGluId() {
        return gluId;
    }

    public void setGluId(Integer gluId) {
        this.gluId = gluId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public float getGlu() {
        return glu;
    }

    public void setGlu(Float glu) {
        this.glu = glu;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Glu{" +
                "gluId=" + gluId +
                ", userId=" + userId +
                ", glu=" + glu +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
