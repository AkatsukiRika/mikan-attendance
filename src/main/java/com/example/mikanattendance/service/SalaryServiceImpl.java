package com.example.mikanattendance.service;

import com.example.mikanattendance.dao.ISalaryDao;
import com.example.mikanattendance.entity.ProductOrder;
import com.example.mikanattendance.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    private ISalaryDao salaryDao;

    @Override
    public int insert(Salary salary) {
        return salaryDao.insert(salary);
    }

    @Override
    public int delete(Salary salary) {
        return salaryDao.delete(salary);
    }

    @Override
    public int updateByPrimaryKeySelective(Salary salary) {
        return salaryDao.updateByPrimaryKeySelective(salary);
    }

    @Override
    public List<Salary> select(Salary salary) {
        return salaryDao.select(salary);
    }

    @Override
    public List<Salary> selectAll() {
        return salaryDao.selectAll();
    }
}
