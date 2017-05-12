/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * UserAuthServiceImpl.java
 */
package com.kew.boss.service.impl;

import com.kew.boss.mapper.RoleFunOptMapper;
import com.kew.boss.mapper.UserRbacMapper;
import com.kew.boss.model.FunRole;
import com.kew.boss.model.Role;
import com.kew.boss.model.User;
import com.kew.boss.service.UserAuthService;
import com.kew.constants.SysConstants;
import com.kew.utils.UtilOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserAuthServiceImpl  implements UserAuthService {
	/**
	 * 角色资源Mapper
	 */
	@Autowired
	private RoleFunOptMapper roleFunOptMapper;
	
	/**
	 * 用户鉴权Mapper
	 */
	@Autowired
	private UserRbacMapper userRbacMapper;
	
	/**
	 * 获取所有的资源角色映射关系
     * @return 资源角色映射关系
	 */
	@Transactional(readOnly = true)
	public Map<String,List<String>> getAllFunRole(){
		// 获取所有的资源角色映射数据
		 List<FunRole> funRoleList = roleFunOptMapper.selectAllRoleFun();
		 // 建立<资源url，角色list>map数据结构
		 Map<String,List<String>> funRolesMap = new HashMap<String,List<String>>();
		 for(FunRole funRole : funRoleList){
			 if(funRolesMap.get(funRole.getUrl()) == null){
				 funRolesMap.put(funRole.getUrl(), new ArrayList<String>());
			 }
			 funRolesMap.get(funRole.getUrl()).add(funRole.getRoleId().toString());
		 }
		 return funRolesMap;
	}

	/**
	 * 用户认证
	 * @param user 用户
     * @return A：认证成功，B：密码不正确，C：loginId不存在
	 */
	@Transactional(readOnly = true)
	public  String userAuth(User user){
		// 根据登录id获取用户信息
		User userTemp = userRbacMapper.getUserByLoginId(user.getLoginId());
		if(userTemp != null){
			
			String userPwd = user.getPwd();
			//用md5验证
			String pwd = UtilOperation.getMD5(userPwd);
			
			if(userTemp.getPwd().equals(pwd)){
				user.setUserId(userTemp.getUserId());
				// 设置用户角色
				user.setRoleList(userRbacMapper.getRloesByUserId(userTemp.getUserId()));
				return SysConstants.USER_AUTH_RESULT_A;
			}
			else {
				return SysConstants.USER_AUTH_RESULT_B;
			}
		}
		else {
			return SysConstants.USER_AUTH_RESULT_C;
		}
	}
	
	/**
	 * 通过roleId获得角色列表
	 * @param userId 用户
     * @return 
	 */
	@Transactional(readOnly = true)
	public List<Role> getRoleListByUserId(long userId){
		return userRbacMapper.getRloesByUserId(userId);
	}
}
