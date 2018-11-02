package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author links
 * @since 2018-10-27
 */
public interface IUserService extends IService<User> {
    User get(User user);
}
