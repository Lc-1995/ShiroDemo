package com.lc.shiro.controller;

import com.lc.shiro.pojo.User;
import com.lc.shiro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 23:30
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userServiceImpl;


    @RequestMapping("/getList")
    public ModelAndView getList() {
        List<User> users = userServiceImpl.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",users);
        mav.setViewName("userInfo");
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(String id) {
        System.out.println("获取的数据:" + id);
        return null;
    }
}
