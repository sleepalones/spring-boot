package com.example.multiple.service.impl;

import com.example.multiple.entity.Order;
import com.example.multiple.entity.User;
import com.example.multiple.mapper.order.OrderMapper;
import com.example.multiple.mapper.user.UserMapper;
import com.example.multiple.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:17:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Transactional
    @Override
    public void xa() {
        orderMapper.updateOrder(101L);

        User user = new User();
        user.setUsername("wym");
        user.setAddress("aaa...");
        userMapper.insertUser(user);

        //int i = 1 / 0;
    }
}
