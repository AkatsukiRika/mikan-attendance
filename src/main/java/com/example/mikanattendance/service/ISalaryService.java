package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.Salary;

import java.util.List;

public interface ISalaryService {
    int insert(Salary salary);

    int delete(Salary salary);
    
    int updateByPrimaryKeySelective(Salary salary);

    List<Salary> select(Salary salary);

    List<Salary> selectAll();
}
