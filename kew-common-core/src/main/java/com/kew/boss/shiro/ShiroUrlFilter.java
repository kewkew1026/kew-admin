package com.kew.boss.shiro;

import com.kew.boss.model.FunOpt;
import com.kew.boss.model.SysLog;
import com.kew.boss.model.UserInfo;
import com.kew.boss.service.FunOptService;
import com.kew.constants.SysConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by qiudanping on 2017/5/9.
 */
public class ShiroUrlFilter extends AuthorizationFilter {

    @Value("${boss.cookie.username}")
    private String cookieLoginName;

    @Value("${boss.cookie.token}")
    private String cookieToken;

    @Autowired
    private FunOptService funOptService;

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        String loginName = null;
        String loginToken = null;

        Subject subject = getSubject(request, response);
        //登录不成功 返回登录页面？
        if(!subject.isAuthenticated()) {
            try {
                HttpServletRequest req = (HttpServletRequest)request;
                Cookie[] cookies =  req.getCookies();

                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals(cookieLoginName)){
                        loginName = cookie.getValue();
                    }
                    if(cookie.getName().equals(cookieToken)){
                        loginToken = cookie.getValue();
                    }
                }

                if(loginName!=null&&loginToken!=null){
                    UsernamePasswordToken token = new UsernamePasswordToken(loginName,loginToken, true);
                    SecurityUtils.getSubject().login(token);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                subject = getSubject(request, response);
                if(!subject.isAuthenticated()) {
                    response.setContentType("text/html; charset=utf-8");
                    HttpServletResponse myResponse = (HttpServletResponse)response;
                    myResponse.sendError(602,"请重新登录");
                    return false;
                }
            }
        }

        String requestURI = getPathWithinApplication(request);

        //Url不匹配 ？
        if (!subject.isPermitted(requestURI)) {

            HttpServletResponse myResponse = (HttpServletResponse)response;
            myResponse.sendError(601,"权限错误");
            return false;

            //response.setContentType("text/html; charset=utf-8");
            //response.getWriter().print("true");
            //WebUtils.issueRedirect(request, response, getUnauthorizedUrl());

            //return false;
        }
        //??? url加入缓存?
        //SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
        // if (savedRequest != null) {
        // 	WebUtils.issueRedirect(request, response, savedRequest.getRequestUrl());
        // 	return false;
        // }

        /**
         * 记录系统日志
         */
        HttpServletRequest myRequest = (HttpServletRequest)request;
        Map map = myRequest.getParameterMap();
        StringBuffer sb = new StringBuffer();

        if(map.size()<2000){
            Set set = map.keySet();
            Iterator it = set.iterator();
            while(it.hasNext()){
                String param = (String)it.next();
                Object obj = map.get(param);
                String val = "";
                if (obj instanceof String[]){
                    String[] strs = (String[])obj;
                    val = Arrays.toString(strs);//jdk1.5以上才支持，1.4的话就自己循环
                }else{
                    val = obj.toString();
                }

                sb.append("参数:"+param);
                sb.append(";值:"+val);
            }
        }else{
            sb.append("参数太多，不记录");
        }

        UserInfo userInfo = (UserInfo)myRequest.getSession().getAttribute(SysConstants.SESSION_USERINFO);
        SysLog sysLog = new SysLog();
        sysLog.setParam(sb.toString());
        sysLog.setObjectId(myRequest.getRemoteAddr());
        sysLog.setOperTime(new Date());
        if(userInfo!=null){
            sysLog.setOperCode(userInfo.getUserId()+"");
        }
        sysLog.setFunUrl(requestURI);
        FunOpt funOpt = funOptService.getByUrl(requestURI);
        if(funOpt!=null){
            sysLog.setFunId(funOpt.getFunOptId()+"");
            sysLog.setFunContent(funOpt.getFunOptNm());
        }

        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
                                      Object mappedValue) {
        //是否对应 ShiroDbRealm 中doGetAuthenticationInfo方法
        if (isLoginRequest(request, response)) {
            return true;
        }
        //是否对应 ShiroDbRealm 中doGetAuthorizationInfo方法
        if (isUnauthorizedRequest(request)) {
            return true;
        }
//		Subject subject = getSubject(request, response);
//		if(!subject.isAuthenticated()) {
//			return false;
//		}
//		String requestURI = getPathWithinApplication(request);
//		if (!subject.isPermitted(requestURI)) {
//			return false;
//		}
        return false;
//		return true;
    }

    private boolean isUnauthorizedRequest(ServletRequest request) {
        return pathsMatch(getUnauthorizedUrl(), request);
    }

    public String getUrl(HttpServletRequest request){
        return getPathWithinApplication(request);
    }
}
