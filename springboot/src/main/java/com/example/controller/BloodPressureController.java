package com.example.controller;

import com.example.common.Result;
import com.example.entity.BloodPressure;
import com.example.entity.BloodPressureECharts;
import com.example.service.BloodPressureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bloodPressure")
public class BloodPressureController {

    @Resource
    private BloodPressureService bloodPressureService;

    @PostMapping("/add")
    public Result add(@RequestBody BloodPressure bloodPressure){
        bloodPressureService.add(bloodPressure);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(BloodPressure bloodPressure){
        List<BloodPressure> bloodPressures = bloodPressureService.selectAll(bloodPressure);
        return Result.success(bloodPressures);
    }

    @GetMapping("/selectByTime")
    public Result selectByTime(BloodPressure bloodPressure){
        List<String> strings = bloodPressureService.selectAllTime(bloodPressure);
        return Result.success(strings);
    }

    @GetMapping("/selectBySBP")
    public Result selectBySBP(BloodPressure bloodPressure){
        List<String> strings = bloodPressureService.selectAllSbp(bloodPressure);
        return Result.success(strings);
    }

    @GetMapping("/selectByDbp")
    public Result selectByDbp(BloodPressure bloodPressure){
        List<String> strings = bloodPressureService.selectAllDbp(bloodPressure);
        return Result.success(strings);
    }

    @GetMapping("/selectEChartsByUserId")
    public Result selectECharts(BloodPressure bloodPressure){
        BloodPressureECharts bloodPressureECharts = bloodPressureService.selectAllECharts(bloodPressure);
        return Result.success(bloodPressureECharts);
    }
}
