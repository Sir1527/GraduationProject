package com.example.mapper;

import com.example.entity.Glu;

import java.util.List;

public interface GluMapper {

    int insert (Glu glu);

    List<Glu> selectAll(Glu glu);

}
