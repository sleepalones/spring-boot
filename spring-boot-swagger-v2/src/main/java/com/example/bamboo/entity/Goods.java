package com.example.bamboo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author brotherming
 * @createTime 2024年08月02日 22:16:00
 */
@Data
public class Goods {

    private Integer id;

    private String goodsName;

    private BigDecimal goodsPrice;

}
