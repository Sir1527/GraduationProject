package com.example.entity;

import java.util.List;

public class BloodPressureECharts {
    private List<String> time;
    private List<Integer> sbp;
    private List<Integer> dbp;

    public BloodPressureECharts() {
    }

    public BloodPressureECharts(List<String> time, List<Integer> sbp, List<Integer> dbp) {
        this.time = time;
        this.sbp = sbp;
        this.dbp = dbp;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Integer> getSbp() {
        return sbp;
    }

    public void setSbp(List<Integer> sbp) {
        this.sbp = sbp;
    }

    public List<Integer> getDbp() {
        return dbp;
    }

    public void setDbp(List<Integer> dbp) {
        this.dbp = dbp;
    }

    @Override
    public String toString() {
        return "BloodPressureECharts{" +
                "time=" + time +
                ", sbp=" + sbp +
                ", dbp=" + dbp +
                '}';
    }
}
