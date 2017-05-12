package com.kew.boss.shiro;

import com.kew.boss.model.Role;
import com.kew.boss.model.User;
import com.kew.boss.model.UserInfo;
import com.kew.boss.service.FunOptService;
import com.kew.boss.service.RbacService;
import com.kew.boss.service.UserAuthService;
import com.kew.constants.SysConstants;
import com.kew.utils.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by qiudanping on 2017/5/9.
 */
public class ShiroDbRealm  extends AuthorizingRealm {

    @Autowired
    private RbacService rbacService;

    @Autowired
    private FunOptService funOptService ;

    @Autowired
    private UserAuthService userAuthService ;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        try {
            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            User user = rbacService.authUser(token.getUsername(), new String(token.getPassword()));

            if (user != null) {
                UserInfo userInfo = rbacService.getUserInfoById(user.getUserId());
                List<Role> roles = userAuthService.getRoleListByUserId(user.getUserId());
                userInfo.setRoleList(roles);
                userInfo.setLoginId(user.getLoginId());
                // 设置登录时间
                userInfo.setLoginTime(DateUtil.dateToString(new Date(),DateUtil.DATESTYLE_LONG));
                SecurityUtils.getSubject().getSession().setAttribute(SysConstants.SESSION_USERINFO, userInfo);

                //更新下缓存
                clearAllCachedAuthorizationInfo();

                return new SimpleAuthenticationInfo(user.getLoginId(), user.getPwd(), getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //调用这2个方法 是按传入名称区分的么  SimpleAuthorizationInfo是缓存？

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        try {
            String loginName = (String) principals.fromRealm(getName()).iterator().next();
            User user = rbacService.getUserByName(loginName);
            if (user != null) {
                List<String> urls = funOptService.getFunOptUrlByUserId(user.getUserId());
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                info.addStringPermissions(urls);
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }

}
