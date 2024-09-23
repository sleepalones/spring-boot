package com.example.bamboo.service;

import com.example.bamboo.entity.User;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月04日 13:03:00
 */
public interface UserService {
    List<User> getUserList();

    User findUserById(Integer id);

}
