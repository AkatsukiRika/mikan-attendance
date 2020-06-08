package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.Salary;

public interface ISalaryService {
    int insert(Salary salary);

    int delete(Salary salary);
    
    int updateByPrimaryKeySelective(Salary salary);

    Salary selectOne(Salary salary);
}
