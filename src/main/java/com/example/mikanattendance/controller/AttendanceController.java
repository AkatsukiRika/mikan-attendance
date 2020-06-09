package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.Attendance;
import com.example.mikanattendance.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    private IAttendanceService attendanceService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    private BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    private BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    private boolean isIllegalStatus(Short status) {
        return status < 0 || status > 1;
    }

    @PostMapping(value = "/attendance/")
    public BasicResponse insert(@RequestBody Attendance attendance) {
        BasicResponse response = null;
        if(isIllegalStatus(attendance.getAttendanceType())) {
            response = createResponse(false, null, "attendance type out of range");
            return response;
        }
        int result = attendanceService.insert(attendance);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/attendance/")
    public BasicResponse delete(@RequestBody Attendance attendance) {
        int result = attendanceService.delete(attendance);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/attendance/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody Attendance attendance) {
        BasicResponse response = null;
        if(isIllegalStatus(attendance.getAttendanceType())) {
            response = createResponse(false, null, "attendance type out of range");
            return response;
        }
        int result = attendanceService.updateByPrimaryKeySelective(attendance);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/attendance/")
    public BasicResponse select(@RequestBody Attendance attendance) {
        if(attendance == null) {
            List<Attendance> result = attendanceService.selectAll();
        }
        List<Attendance> result = attendanceService.select(attendance);
        return createResponse(true, result, null);
    }
}
