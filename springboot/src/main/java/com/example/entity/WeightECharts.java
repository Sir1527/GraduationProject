package com.example.entity;

import java.util.List;

public class WeightECharts {
    List<Integer> weight;
    List<Integer> BMI;
    List<String> time;

    public WeightECharts() {
    }

    public WeightECharts(List<Integer> weight, List<Integer> BMI, List<String> time) {
        this.weight = weight;
        this.BMI = BMI;
        this.time = time;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public void setWeight(List<Integer> weight) {
        this.weight = weight;
    }

    public List<Integer> getBMI() {
        return BMI;
    }

    public void setBMI(List<Integer> BMI) {
        this.BMI = BMI;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeightECharts{" +
                "weight=" + weight +
                ", BMI=" + BMI +
                ", time=" + time +
                '}';
    }
}
