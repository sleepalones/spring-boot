package com.example.multiple.service.impl;

import com.example.multiple.entity.User;
import com.example.multiple.mapper.user.UserMapper;
import com.example.multiple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:16:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
