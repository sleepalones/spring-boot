package com.example.multiple.service;


import com.example.multiple.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:16:00
 */
public interface OrderService {
    List<Order> findAll();

    void xa();

}
