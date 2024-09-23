package org.example.spring.dev.entity;

import lombok.Getter;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:15:00
 */
@Getter
public class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public User() {
        System.out.println("user...");
    }
}
