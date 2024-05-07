package com.example.controller;

import com.example.common.Result;
import com.example.entity.Weight;
import com.example.entity.WeightECharts;
import com.example.service.WeightService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weight")
public class WeightController {

    @Resource
    private WeightService weightService;

    @PostMapping("/add")
    public Result add(@RequestBody Weight weight) {
        weightService.add(weight);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Weight weight) {
        return Result.success(weightService.selectAll(weight));
    }

    @GetMapping("/selectEcharts")
    public Result selectEcharts(Weight weight) {
        WeightECharts weightECharts = weightService.selectAllECharts(weight);
        return Result.success(weightECharts);
    }
}
