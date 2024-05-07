package com.example.entity;

public class Weight {
    private Integer weightId;
    private Integer userId;
    private Integer weight;
    private Integer BMI;
    private String createTime;

    public Weight() {
    }

    public Weight(Integer weightId, Integer userId, Integer weight, Integer BMI, String createTime) {
        this.weightId = weightId;
        this.userId = userId;
        this.weight = weight;
        this.BMI = BMI;
        this.createTime = createTime;
    }

    public Integer getWeightId() {
        return weightId;
    }

    public void setWeightId(Integer weightId) {
        this.weightId = weightId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getBMI() {
        return BMI;
    }

    public void setBMI(Integer BMI) {
        this.BMI = BMI;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weightId=" + weightId +
                ", userId=" + userId +
                ", weight=" + weight +
                ", BMI=" + BMI +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
