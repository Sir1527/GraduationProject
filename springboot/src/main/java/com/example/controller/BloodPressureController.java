package com.example.controller;

import com.example.common.Result;
import com.example.entity.BloodPressure;
import com.example.service.BloodPressureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bloodPressure")
public class BloodPressureController {

    @Resource
    private BloodPressureService bloodPressureService;

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
}
