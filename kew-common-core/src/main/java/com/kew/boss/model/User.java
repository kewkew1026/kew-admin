/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * User.java
 */
package com.kew.boss.model;
/**
 * [文件名称]<br>
 * User <br>
 * <br>
 * [文件描述]<br>
 * 用户认证信息<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-4 ver1.00 创建 ji_qingyang<br>
 * 
 * @author ji_qingyang
 * @version 1.00
 */
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	/**
	 * 实序列id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private long userId;
	
	/**
	 * 登录id
	 */
	private String loginId;
	
	/**
	 * 密码
	 */
	private String pwd;

	/**
	 * 用户角色list
	 */
	private List<Role> roleList;

    /**
     * 获取用户id
     * 
     * @return 用户id
     */
	public long getUserId() {
		return userId;
	}
	
    /**
     * 设置用户id
     * 
     * @param userId
     *            用户id
     */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
    /**
     * 获取登录id
     * 
     * @return 登录id
     */
	public String getLoginId() {
		return loginId;
	}
	
    /**
     * 设置登录id
     * 
     * @param loginId
     *            登录id
     */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
    /**
     * 获取密码
     * 
     * @return 密码
     */
	public String getPwd() {
		return pwd;
	}
	
    /**
     * 设置密码
     * 
     * @param pwd
     *            密码
     */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
    /**
     * 获取用户角色list
     * 
     * @return 用户角色list
     */
	public List<Role> getRoleList() {
		return roleList;
	}
	
    /**
     * 设置用户角色list
     * 
     * @param roleList
     *            用户角色list
     */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}
