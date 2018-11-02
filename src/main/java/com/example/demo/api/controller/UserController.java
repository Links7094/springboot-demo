package com.example.demo.api.controller;


import com.example.demo.api.ResponseResult;
import com.example.demo.api.dto.UserInput;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
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
    public ResponseResult get(UserInput userInput){
        User param = userInput.convert();
        User result = userService.get(param);
        return new ResponseResult<>(ResponseResult.ResultCode.SUCCESS, "查询成功", result);
    }
}
