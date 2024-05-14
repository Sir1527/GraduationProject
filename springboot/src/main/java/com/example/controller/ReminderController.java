package com.example.controller;

import com.example.common.Result;
import com.example.entity.Reminder;
import com.example.service.ReminderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @Resource
    private ReminderService reminderService;

    @PostMapping("/add")
    public Result add(@RequestBody Reminder reminder){
        reminderService.add(reminder);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Reminder reminder){
        List<Reminder> reminders = reminderService.selectAll(reminder);
        return Result.success(reminders);
    }
}
