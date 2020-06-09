package com.example.mikanattendance.service;

import com.example.mikanattendance.dao.ISuggestionDao;
import com.example.mikanattendance.entity.Salary;
import com.example.mikanattendance.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements ISuggestionService {
    @Autowired
    private ISuggestionDao suggestionDao;

    @Override
    public int insert(Suggestion suggestion) {
        return suggestionDao.insert(suggestion);
    }

    @Override
    public int delete(Suggestion suggestion) {
        return suggestionDao.delete(suggestion);
    }

    @Override
    public int updateByPrimaryKeySelective(Suggestion suggestion) {
        return suggestionDao.updateByPrimaryKeySelective(suggestion);
    }

    @Override
    public List<Suggestion> select(Suggestion suggestion) {
        return suggestionDao.select(suggestion);
    }

    @Override
    public List<Suggestion> selectAll() {
        return suggestionDao.selectAll();
    }
}
