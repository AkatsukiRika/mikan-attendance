package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.Suggestion;

import java.util.List;

public interface ISuggestionService {
    int insert(Suggestion suggestion);

    int delete(Suggestion suggestion);
    
    int updateByPrimaryKeySelective(Suggestion suggestion);

    List<Suggestion> select(Suggestion suggestion);

    List<Suggestion> selectAll();
}
