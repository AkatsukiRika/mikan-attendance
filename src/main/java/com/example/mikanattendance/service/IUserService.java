package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.User;

import java.util.List;

public interface IUserService {
    int insert(User user);

    int delete(User user);

    int updateByPrimaryKeySelective(User user);

    List<User> select(User user);

    List<User> selectAll();
}
