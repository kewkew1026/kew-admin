/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * UserAuthService.java
 */
package com.kew.boss.service;


import com.kew.boss.model.Role;
import com.kew.boss.model.User;

import java.util.List;
import java.util.Map;


public interface UserAuthService {
	
	/**
	 * 获取所有的资源角色映射关系
     * @return 资源角色映射关系
	 */
	 Map<String,List<String>>  getAllFunRole();
	
	/**
	 * 用户认证
	 * @param user 用户
     * @return A：认证成功，B：密码不正确，C：loginId不存在
	 */
	 String userAuth(User user);
	
	/**
	 * 通过roleId获得角色列表
	 * @param user 用户
     * @return 
	 */
	 List<Role> getRoleListByUserId(long userId);
}
