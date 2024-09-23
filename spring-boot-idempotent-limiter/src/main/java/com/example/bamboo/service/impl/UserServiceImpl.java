package com.example.bamboo.service.impl;

import com.example.bamboo.entity.User;
import com.example.bamboo.mapper.UserMapper;
import com.example.bamboo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月04日 13:03:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

}
