package com.example.mapper;

import com.example.entity.Weight;

import java.util.List;

public interface WeightMapper {

    int insert (Weight weight);

    List<Weight> selectAll(Weight weight);

}
