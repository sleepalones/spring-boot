package com.example.bamboo.controller;

import com.example.bamboo.entity.Goods;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author brotherming
 * @createTime 2024年08月02日 22:15:00
 */
@RestController
public class GoodsController {

    @ApiOperation("根据id获取商品信息")
    @GetMapping("/getGoods")
    public Goods getGoods(@RequestParam("id") Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setGoodsName("goods name");
        goods.setGoodsPrice(BigDecimal.valueOf(100));
        return goods;
    }

}
