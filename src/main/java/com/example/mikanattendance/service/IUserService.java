package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.User;

public interface IUserService {
    int insert(User user);

    int delete(User user);

    int updateByPrimaryKeySelective(User user);

    User selectOne(User user);
}
