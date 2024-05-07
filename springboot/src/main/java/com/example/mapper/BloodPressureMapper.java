package com.example.mapper;

import com.example.entity.BloodPressure;
import com.example.entity.Post;

import java.util.List;

public interface BloodPressureMapper {

    int insert (BloodPressure bloodPressure);

    List<BloodPressure> selectAll(BloodPressure bloodPressure);
}
