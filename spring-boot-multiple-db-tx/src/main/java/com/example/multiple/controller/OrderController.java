package com.example.multiple.controller;

import com.example.multiple.entity.Order;
import com.example.multiple.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:14:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @PostMapping("/xa")
    public void testXA() {
        orderService.xa();
    }

}
