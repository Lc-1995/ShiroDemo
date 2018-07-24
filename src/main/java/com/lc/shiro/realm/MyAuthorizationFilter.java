package com.lc.shiro.realm;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: lichao
 * @Description: 自定义Roles授权规则,实现满足一个条件即可
 * @Date: 2018/7/24 11:33
 */
public class MyAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        // 获取shiro管理对象
        Subject subject = getSubject(request,response);
        // 获取限制的角色
        String[] roles = (String[]) mappedValue;
        // 角色集为null,当前没有设置角色限制,放行
        if (roles == null || roles.length < 0) {
            return true;
        }
        for (int i = 0; i < roles.length; i++) {
            // 当前用户拥有任意一个角色则可以访问
            if (subject.hasRole(roles[i])) {
                return true;
            }
        }
        return false;
    }
}
