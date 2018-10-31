package com.example.demo.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.api.ResponseResult;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author links
 * @since 2018-10-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/get")
    public ResponseResult get(){
//        User user = userService.getById(1);
//        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","account","password");
        wrapper.eq("id", 1);
        User one = userService.getOne(wrapper);
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS, "成功", one);
    }
}
