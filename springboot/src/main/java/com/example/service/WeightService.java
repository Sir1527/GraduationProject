package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Weight;
import com.example.entity.WeightECharts;
import com.example.mapper.WeightMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WeightService {

    @Resource
    private WeightMapper weightMapper;

    public void add(Weight weight) {
        weight.setCreateTime(DateUtil.now());
        weightMapper.insert(weight);
    }

    public List<Weight> selectAll(Weight weight) {
        return weightMapper.selectAll(weight);
    }

    public WeightECharts selectAllECharts(Weight weight) {
        List<Weight> weights = weightMapper.selectAll(weight);
        WeightECharts weightECharts = new WeightECharts();
        List<Integer> weight1 = new ArrayList<Integer>();
        List<Integer> BMI = new ArrayList<Integer>();
        List<String> time = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            weight1.add(weights.get(i).getWeight());
            BMI.add(weights.get(i).getBMI());
            time.add(weights.get(i).getCreateTime());
        }
        Collections.reverse(weight1);
        Collections.reverse(BMI);
        Collections.reverse(time);
        weightECharts.setWeight(weight1);
        weightECharts.setBMI(BMI);
        weightECharts.setTime(time);
        return weightECharts;
    }
}
