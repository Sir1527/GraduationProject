package com.example.entity;

public class BloodPressure {
    private Integer BPid;
    private Integer userId;
    private Integer sbp;
    private Integer dbp;
    private String createTime;

    public BloodPressure() {
    }

    public BloodPressure(Integer BPid, Integer userId, Integer sbp, Integer dbp, String createTime) {
        this.BPid = BPid;
        this.userId = userId;
        this.sbp = sbp;
        this.dbp = dbp;
        this.createTime = createTime;
    }

    public Integer getBPid() {
        return BPid;
    }

    public void setBPid(Integer BPid) {
        this.BPid = BPid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BloodPressure{" +
                "BPid=" + BPid +
                ", userId=" + userId +
                ", sbp=" + sbp +
                ", dbp=" + dbp +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
