package com.example.multiple.mapper.user;

import com.example.multiple.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:18:00
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    @Insert("insert into tb_user (username, address) values (#{user.username}, #{user.address})")
    void insertUser(@Param("user") User user);
}
