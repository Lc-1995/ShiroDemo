package com.lc.shiro.service;

import com.lc.shiro.pojo.User;

import java.util.List;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 22:53
 */
public interface UserService {

    User findUserByName(String username);

    List<User> findAll();
}
