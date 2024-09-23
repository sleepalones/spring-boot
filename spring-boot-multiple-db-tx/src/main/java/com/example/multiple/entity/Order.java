package com.example.multiple.entity;

import lombok.Data;

/**
 * @author brotherming
 * @createTime 2024年07月27日 16:20:00
 */
@Data
public class Order {

    private Long id;
    private Long userId;
    private String name;
    private Long price;
    private Integer num;

}
