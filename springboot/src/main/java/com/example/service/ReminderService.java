package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Reminder;
import com.example.mapper.ReminderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReminderService {
    @Resource
    private ReminderMapper reminderMapper;

    public void add(Reminder reminder) {
        reminder.setCreateTime(DateUtil.now());
        reminderMapper.insert(reminder);
    }

    public List<Reminder> selectAll(Reminder reminder) {
        return reminderMapper.selectAll(reminder);
    }
}
