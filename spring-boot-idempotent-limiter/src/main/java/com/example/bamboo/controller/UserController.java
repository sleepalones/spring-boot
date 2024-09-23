package com.example.bamboo.controller;

import com.example.bamboo.annotation.ApiIdempotent;
import com.example.bamboo.annotation.Limiter;
import com.example.bamboo.entity.User;
import com.example.bamboo.service.UserService;
import com.example.bamboo.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月04日 13:02:00
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public String token() {
        return tokenService.generateToken();
    }

    @ApiIdempotent
    @GetMapping("/userList")
    public List<User> userList() {
        return userService.getUserList();
    }

    @Limiter(value = 2)
    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
}
