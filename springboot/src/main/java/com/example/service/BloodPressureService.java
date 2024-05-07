package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.BloodPressure;
import com.example.entity.BloodPressureECharts;
import com.example.mapper.BloodPressureMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BloodPressureService {

    @Resource
    private BloodPressureMapper bloodPressureMapper;

    public List<BloodPressure> selectAll(BloodPressure bloodPressure){
        return bloodPressureMapper.selectAll(bloodPressure);
    }

    public void add(BloodPressure bloodPressure){
        bloodPressure.setCreateTime(DateUtil.now());
        bloodPressureMapper.insert(bloodPressure);
    }

    public List<String> selectAllSbp(BloodPressure bloodPressure){
        List<BloodPressure> bloodPressures = bloodPressureMapper.selectAll(bloodPressure);
        List sbpList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            sbpList.add(bloodPressures.get(i).getSbp());
        }
        return sbpList;
    }

    public List<String> selectAllDbp(BloodPressure bloodPressure){
        List<BloodPressure> bloodPressures = bloodPressureMapper.selectAll(bloodPressure);
        List dbpList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            dbpList.add(bloodPressures.get(i).getDbp());
        }
        return dbpList;
    }

    public List<String> selectAllTime(BloodPressure bloodPressure){
        List<BloodPressure> bloodPressures = bloodPressureMapper.selectAll(bloodPressure);
        List timeList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            timeList.add(bloodPressures.get(i).getCreateTime());
        }
        return timeList;
    }

    public BloodPressureECharts selectAllECharts(BloodPressure bloodPressure) {
        List<BloodPressure> bloodPressures = bloodPressureMapper.selectAll(bloodPressure);
        BloodPressureECharts bloodPressureECharts = new BloodPressureECharts();
        List sbpList = new ArrayList<String>();
        List dbpList = new ArrayList<String>();
        List timeList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            sbpList.add(bloodPressures.get(i).getSbp());
            dbpList.add(bloodPressures.get(i).getDbp());
            timeList.add(bloodPressures.get(i).getCreateTime());

        }
        Collections.reverse(dbpList);
        Collections.reverse(sbpList);
        Collections.reverse(timeList);
        bloodPressureECharts.setDbp(dbpList);
        bloodPressureECharts.setSbp(sbpList);
        bloodPressureECharts.setTime(timeList);
        return bloodPressureECharts;
    }
}
