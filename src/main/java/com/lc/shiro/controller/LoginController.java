package com.lc.shiro.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 16:59
 */
@Controller
public class LoginController {

    private final static Logger LOG = LogManager.getLogger(LoginController.class);

    @RequestMapping("/")
    public ModelAndView toHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

    /**
     *
     * @Description: 前端提交的登录表单请求
     * @auther: lichao
     * @date: 2018/7/23 23:23
     * @param: [username, password]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView toLogin(String username, String password) {
        ModelAndView mav = new ModelAndView();
        // 获取shiro管理对象
        Subject subject = SecurityUtils.getSubject();
        // 用户未被认证时
        if (!subject.isAuthenticated()) {
            // 封装username,password
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                // shiro进行登录认证,realm
                subject.login(token);
            } catch (AuthenticationException e) {
                LOG.info("用户认证失败:" + e.getMessage());
                mav.setViewName("login");
                return mav;
            }
        }
        // 登录成功或者已经登录了直接进入主页
        mav.setViewName("redirect:/");
        return mav;
    }

    /**
     *
     * @Description: 没有认证时进入的页面
     * @auther: lichao
     * @date: 2018/7/23 23:23
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    /**
     *
     * @Description: 没有权限的页面
     * @auther: lichao
     * @date: 2018/7/23 23:21
     * @param: []
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/unauthorized")
    public ModelAndView toUnauthorized() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("unauthorized");
        return mav;
    }
}
