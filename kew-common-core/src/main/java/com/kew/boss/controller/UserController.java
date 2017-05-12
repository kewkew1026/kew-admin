package com.kew.boss.controller;

import com.kew.boss.model.Menue;
import com.kew.boss.model.SysLog;
import com.kew.boss.model.UserInfo;
import com.kew.boss.utils.MenuUtil;
import com.kew.constants.SysConstants;
import com.kew.utils.UtilOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by qiudanping on 2017/5/10.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Value("${boss.cookie.username}")
    private String cookieLoginName;

    @Value("${boss.cookie.token}")
    private String cookieToken;

    @Value("${boss.cookie.domain}")
    private String cookieDomain;

    @Value("${boss.domain}")
    private String bossDiomain;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login( String userName, String password) {
        return "/login";
    }

    /**
     * 用户进行权限认证
     * @param model
     * @param username
     * @param password
     * @param rememberMe
     * @return
     */
    @RequestMapping("/auth")
    public String auth(Model model, String username, String password, boolean rememberMe, HttpServletRequest request, HttpServletResponse response) {

        String validateCode = "";
        if(SysConstants.VALIDATE_CODE){
            validateCode = request.getParameter("validateCode");
            String number = (String)request.getSession().getAttribute("number");

            if(number==null){
                return "/login";
            }

            if(!number.equals(validateCode)){
                request.setAttribute("message","验证码错误");
                model.addAttribute("username",username);
                model.addAttribute("rememberMe",rememberMe);
                model.addAttribute("password",password);
                return "/login";
            }
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, UtilOperation.getMD5(password), rememberMe);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("rememberMe",rememberMe);
            model.addAttribute("message","用户名或密码错误");
            return "/login";
        }

        /**
         * 记录系统日志
         */
        Map map = request.getParameterMap();
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
            sb.append("参数太多,不记录");
        }

        SysLog sysLog = new SysLog();
        sysLog.setObjectId(request.getRemoteAddr());
        sysLog.setParam(sb.toString());
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(SysConstants.SESSION_USERINFO);
        if(userInfo!=null){
            sysLog.setOperCode(userInfo.getUserId()+"");
        }
        sysLog.setFunUrl(request.getServletPath());
        //FunOpt funOpt = funOptService.getByUrl(request.getServletPath());
        //if(funOpt!=null){
        //	sysLog.setFunId(funOpt.getFunOptId()+"");
        //	sysLog.setFunContent(funOpt.getFunOptNm());
        //}
        sysLog.setFunContent("用户登录");
        sysLog.setSerCode(validateCode);
        sysLog.setOperTime(new Date());

        Cookie cookieUserName = new Cookie(cookieLoginName, username);
        cookieUserName.setDomain(cookieDomain);
        cookieUserName.setPath("/");

        Cookie cookiePass = new Cookie(cookieToken, UtilOperation.getMD5(password));
        cookiePass.setDomain(cookieDomain);
        cookiePass.setPath("/");

        response.addCookie(cookieUserName);
        response.addCookie(cookiePass);

        model.addAttribute("bossDiomain",bossDiomain);

        // 获取所有的菜单
        Menue menue = menueService.getRootMenue(true, MenuUtil.getRoleIds(request), MenuUtil.getUsername(request));
        if(menue==null){
            model.addAttribute("menues",new ArrayList<Menue>());
        }else{
            model.addAttribute("menues", menue.getChildrenMenueList());
        }

        return "/index";
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping("/logoff")
    public String logoff(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/login";
    }
}
