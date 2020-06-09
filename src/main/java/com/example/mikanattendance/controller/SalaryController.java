package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.Salary;
import com.example.mikanattendance.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    private BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    private BasicResponse createResponse(Object result) {
        return baseController.createResponse(true, result, null);
    }

    @PostMapping(value = "/salary/")
    public BasicResponse insert(@RequestBody Salary salary) {
        BasicResponse response = null;
        int result = salaryService.insert(salary);
        response = createResponse(result);
        return response;
    }

    @DeleteMapping(value = "/salary/")
    public BasicResponse delete(@RequestBody Salary salary) {
        int result = salaryService.delete(salary);
        return createResponse(result);
    }

    // 必须传ID
    @PatchMapping(value = "/salary/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody Salary salary) {
        int result = salaryService.updateByPrimaryKeySelective(salary);
        return createResponse(result);
    }

    @GetMapping(value = "/salary/")
    public BasicResponse select(@RequestBody Salary salary) {
        if(salary == null) {
            List<Salary> result = salaryService.selectAll();
        }
        List<Salary> result = salaryService.select(salary);
        return createResponse(result);
    }
}
