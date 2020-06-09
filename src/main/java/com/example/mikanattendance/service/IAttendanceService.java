package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.Attendance;

import java.util.List;

public interface IAttendanceService {
    int insert(Attendance attendance);

    int delete(Attendance attendance);
    
    int updateByPrimaryKeySelective(Attendance attendance);

    List<Attendance> select(Attendance attendance);

    List<Attendance> selectAll();
}
