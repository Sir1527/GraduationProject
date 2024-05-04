package com.example.mapper;

import com.example.entity.BloodPressure;

import java.util.List;

public interface BloodPressureMapper {
    List<BloodPressure> selectAll(BloodPressure bloodPressure);
}
