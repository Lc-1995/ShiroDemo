package com.lc.shiro.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView toLogin(String username, String password) {
        LOG.info("获取的数据:" + username + "---" + password);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping("/unauthorized")
    public ModelAndView toUnauthorized() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("unauthorized");
        return mav;
    }
}
