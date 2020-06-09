package com.example.mikanattendance.service;

import com.example.mikanattendance.dao.IUserDao;
import com.example.mikanattendance.entity.Suggestion;
import com.example.mikanattendance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> select(User user) {
        return userDao.select(user);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
