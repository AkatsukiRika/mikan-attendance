package com.example.mikanattendance.service;

import com.example.mikanattendance.dao.IAttendanceDao;
import com.example.mikanattendance.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {
    @Autowired
    private IAttendanceDao attendanceDao;

    @Override
    public int insert(Attendance attendance) {
        return attendanceDao.insert(attendance);
    }

    @Override
    public int delete(Attendance attendance) {
        return attendanceDao.delete(attendance);
    }

    @Override
    public int updateByPrimaryKeySelective(Attendance attendance) {
        return attendanceDao.updateByPrimaryKeySelective(attendance);
    }

    @Override
    public List<Attendance> select(Attendance attendance) {
        return attendanceDao.select(attendance);
    }

    @Override
    public List<Attendance> selectAll() {
        return attendanceDao.selectAll();
    }
}
