package com.example.entity;

import java.util.List;

public class GluECharts {
    List<Float> glu;
    List<String> time;

    public GluECharts() {
    }

    public GluECharts(List<Float> glu, List<String> time) {
        this.glu = glu;
        this.time = time;
    }

    public List<Float> getGlu() {
        return glu;
    }

    public void setGlu(List<Float> glu) {
        this.glu = glu;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "GluECharts{" +
                "glu=" + glu +
                ", time=" + time +
                '}';
    }
}
