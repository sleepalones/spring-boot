package com.example.bamboo.controller;

import com.example.bamboo.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author brotherming
 * @createTime 2024年08月02日 22:15:00
 */
@Api(tags = {"用户控制器"})
@RestController
public class UserController {

    @ApiOperation(value = "获取用户详情", notes = "根据传入id获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", required = true, defaultValue = "0"/*, example = "1234"*/),
            @ApiImplicitParam(name = "username", value = "用户姓名", dataType = "string", required = true, defaultValue = "wym"/*, example = "brotherming"*/),


            @ApiImplicitParam(paramType = "path", name = "status", value = "用户状态", dataType = "int", required = true, defaultValue = "0", example = "1"),
            @ApiImplicitParam(paramType = "token", name = "token", value = "用户token", dataType = "string", required = true, defaultValue = "XXX", example = "token:xxx"),
            @ApiImplicitParam(paramType = "body", name = "user", value = "用户实体", required = true)
    })
    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") Integer id,
                        @RequestParam("username") String username,

                        @PathVariable("status") Integer status,
                        @RequestHeader("token") String token,
                        @RequestBody User user) {
        User user2 = new User();
        user2.setId(id);
        user2.setUsername("wym name");
        user2.setPassword("wym password");
        return user2;
    }

    @ApiIgnore  // 忽略
    @ApiOperation(value = "获取用户详情2", notes = "根据传入id获取用户详细信息2")
    @GetMapping("/getUser2")
    public User getUser2(
            @ApiParam(name = "id", value = "用户id", type = "int", required = true, defaultValue = "0", example = "1234")
            @RequestParam("id") Integer id,

            @ApiParam(name = "username", value = "用户id", type = "string", required = true, defaultValue = "a", example = "wym")
            @RequestParam("username") String username) {
        User user = new User();
        user.setId(id);
        user.setUsername("wym name");
        user.setPassword("wym password");
        return user;
    }

    @ApiOperation(value = "获取用户详情3", notes = "根据传入id获取用户详细信息3")
    @GetMapping("/getUser3")
    public User getUser3(@RequestBody User user) {
        user.setUsername("bamboo");
        return user;
    }

}
