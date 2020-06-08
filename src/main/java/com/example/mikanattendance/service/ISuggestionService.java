package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.Suggestion;

public interface ISuggestionService {
    int insert(Suggestion suggestion);

    int delete(Suggestion suggestion);
    
    int updateByPrimaryKeySelective(Suggestion suggestion);

    Suggestion selectOne(Suggestion suggestion);
}
