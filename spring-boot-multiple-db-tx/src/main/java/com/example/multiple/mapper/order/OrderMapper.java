package com.example.multiple.mapper.order;

import com.example.multiple.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:17:00
 */
@Mapper
public interface OrderMapper {
    List<Order> findAll();

    @Update("update tb_order set num = 2 where id = #{id}")
    void updateOrder(@Param("id") Long id);

}
