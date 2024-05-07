package com.example.controller;

import com.example.common.Result;
import com.example.entity.Glu;
import com.example.service.GluService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/glu")
public class GluController {

    @Resource
    private GluService gluService;

    @PostMapping("/add")
    public Result add(@RequestBody Glu glu) {
        gluService.add(glu);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Glu glu) {
        return Result.success(gluService.selectAll(glu));
    }

    @GetMapping("/selectECharts")
    public Result selectECharts(Glu glu){
        return Result.success(gluService.selectAllECharts(glu));
    }
}
