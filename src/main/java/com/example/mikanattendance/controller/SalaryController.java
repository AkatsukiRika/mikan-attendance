package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.Salary;
import com.example.mikanattendance.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    public BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    public BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    @PostMapping(value = "/salary/")
    public BasicResponse insert(@RequestBody Salary salary) {
        BasicResponse response = null;
        int result = salaryService.insert(salary);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/salary/")
    public BasicResponse delete(@RequestBody Salary salary) {
        int result = salaryService.delete(salary);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/salary/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody Salary salary) {
        int result = salaryService.updateByPrimaryKeySelective(salary);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/salary/")
    public BasicResponse selectOne(@RequestBody Salary salary) {
        Salary result = salaryService.selectOne(salary);
        return createResponse(true, result, null);
    }
}
