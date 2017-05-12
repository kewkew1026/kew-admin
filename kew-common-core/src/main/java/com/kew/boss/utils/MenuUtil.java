/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * 	MenuUtil.java
 */
package com.kew.boss.utils;


import com.kew.boss.model.Role;
import com.kew.boss.model.UserInfo;
import com.kew.constants.SysConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * [文件名称]<br>
 * MenuUtil <br>
 * <br>
 * [文件描述]<br>
 * 菜单工具类<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-4 ver1.00 创建 zhanggang<br>
 * 
 * @author zhanggang
 * @version 1.00
 */
public class MenuUtil {
	
	/**
	 * 通过请求得到用户信息对象
	 * @param request
	 * @return
	 */
	public static UserInfo getFromRequest(HttpServletRequest request){
		return (UserInfo)request.getSession().getAttribute(SysConstants.SESSION_USERINFO);
	}
	
	/**
	 * 通过请求得到用户角色id list
	 * @param request
	 * @return
	 */
	public static List<Long> getRoleIds(HttpServletRequest request){
		List<Long> roleIds = new ArrayList<Long>();
		UserInfo userInfo = getFromRequest(request);
		List<Role> roles = new ArrayList<Role>();
		if(userInfo!=null){
			roles = userInfo.getRoleList();
		}
		for(int i=0;i<roles.size();i++){
			roleIds.add((Long)(long)(int)roles.get(i).getRoleId());
		}
		return roleIds;
	}
	
	/**
	 * 通过请求得到用户登录名称
	 * @param request
	 * @return
	 */
	public static String getUsername(HttpServletRequest request){
		UserInfo userInfo = getFromRequest(request);
		if(userInfo!=null){
			return userInfo.getLoginId();
		}
		return "";
	}
	
	/**
	 * 判断是否是菜单管理员
	 * @param request
	 * @return
	 */
//	public static boolean isMenuManager(HttpServletRequest request){
//		return SysConstants.MENUE_MANAGER.equals(getUsername(request));
//	}
}
