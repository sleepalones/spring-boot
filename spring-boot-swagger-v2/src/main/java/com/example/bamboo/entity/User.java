package com.example.bamboo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author brotherming
 * @createTime 2024年08月02日 22:15:00
 */
@ApiModel
@Data
public class User {

    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

}
