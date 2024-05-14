package com.example.mapper;

import com.example.entity.Reminder;

import java.util.List;

public interface ReminderMapper {
    int insert (Reminder reminder);

    List<Reminder> selectAll(Reminder reminder);
}
