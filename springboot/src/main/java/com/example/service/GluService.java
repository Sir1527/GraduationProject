package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Glu;
import com.example.entity.GluECharts;
import com.example.mapper.GluMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GluService {

    @Resource
    private GluMapper gluMapper;

    public void add(Glu glu){
        glu.setCreateTime(DateUtil.now());
        gluMapper.insert(glu);
    }

    public List<Glu> selectAll(Glu glu){
        return gluMapper.selectAll(glu);
    }

    public GluECharts selectAllECharts(Glu glu){
        List<Glu> glus = gluMapper.selectAll(glu);
        GluECharts gluECharts = new GluECharts();
        List<Float> glus1 = new ArrayList<>();
        List<String> times = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            glus1.add(glus.get(i).getGlu());
            times.add(glus.get(i).getCreateTime());
        }
        Collections.reverse(glus1);
        Collections.reverse(times);
        gluECharts.setGlu(glus1);
        gluECharts.setTime(times);
        return gluECharts;
    }

}
