package com.lc.shiro.service.serviceImpl;

import com.lc.shiro.dao.UserDao;
import com.lc.shiro.pojo.User;
import com.lc.shiro.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 22:53
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDaoImpl;

    @Override
    public User findUserByName(String username) {
        return userDaoImpl.findUserByName(username);
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }
}
