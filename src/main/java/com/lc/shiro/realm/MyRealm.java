package com.lc.shiro.realm;

import com.lc.shiro.pojo.Permission;
import com.lc.shiro.pojo.Role;
import com.lc.shiro.pojo.User;
import com.lc.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 19:10
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userServiceImpl;

    /**
     *
     * @Description: 认证
     * @auther: lichao
     * @date: 2018/7/23 22:49
     * @param: [authenticationToken]
     * @return: org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String username = (String) token.getPrincipal();
        // 通过用户名查询用户对象
        User user = userServiceImpl.findUserByName(username);
        if (null == user) {
            throw new UnknownAccountException("用户不存在!");
        }
        // 当前Realm对象的name
        String realmName = getName();
        /**
         * 参数说明
         * @principal: 认证的实体信息,可以是username,也可以是实体对象
         * @credentials: shiro比对的密码
         * @realmName: 当前Realm对象的name
         * @auther: lichao
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),realmName);
        return info;
    }

    /**
     *
     * @Description: 授权
     * @auther: lichao
     * @date: 2018/7/24 13:01
     * @param: [principal]
     * @return: org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取认证后的用户信息
        User user = (User) principal.getPrimaryPrincipal();
        // 获取用户拥有的角色
        for (Role role : user.getRoles()) {
            info.addRole(role.getName());
            // 获取角色拥有的权限
            for (Permission permission : role.getPermissions()) {
                info.addStringPermission(permission.getName());
            }
        }
        return info;
    }
}
