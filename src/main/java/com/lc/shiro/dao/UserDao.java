package com.lc.shiro.dao;

import com.lc.shiro.pojo.User;

import java.util.List;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 22:55
 */
public interface UserDao {

    User findUserByName(String username);

    List<User> findAll();
}
