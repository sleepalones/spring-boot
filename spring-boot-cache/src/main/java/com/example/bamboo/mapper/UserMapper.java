package com.example.bamboo.mapper;

import com.example.bamboo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月04日 13:04:00
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    @Select("select * from tb_user where id = #{id}")
    User findUserById(@Param("id") Integer id);
}
