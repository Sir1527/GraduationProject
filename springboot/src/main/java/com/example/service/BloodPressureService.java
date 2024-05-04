package com.example.service;

import com.example.entity.BloodPressure;
import com.example.mapper.BloodPressureMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class BloodPressureService {

    @Resource
    private BloodPressureMapper bloodPressureMapper;

    public List<BloodPressure> selectAll(BloodPressure bloodPressure){
        return bloodPressureMapper.selectAll(bloodPressure);
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
}
