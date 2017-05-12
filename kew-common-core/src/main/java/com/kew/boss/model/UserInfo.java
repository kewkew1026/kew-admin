package com.kew.boss.model;

import java.io.Serializable;

/*
 * 后台操作员属性
 */
public class UserInfo extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long userId;                 //用户ID
	private String name ;                //用户名
	private String userDepartment;       //用户部门
	private String userPosition;         //用户职位
	private long userGroupId ;           //用户组ID
	private String userStatus ;          //状态
	private String loginTime ;           //登录时间
	
	private Long userDepartId;           //用户部门ID
	private Long userPosiId;			 //用户职位ID
	
	private String userDepartName;       //区域名
	private String userPosiName;         //职位名
	
	private String mgrproles;//所在组对应角色
	private String mroles;//对应角色
	
	private long oneRoleID;//检索条件 角色id
	
	public long getOneRoleID() {
		return oneRoleID;
	}

	public void setOneRoleID(long oneRoleID) {
		this.oneRoleID = oneRoleID;
	}

	public String getMgrproles() {
		return mgrproles;
	}

	public void setMgrproles(String mgrproles) {
		this.mgrproles = mgrproles;
	}

	public String getMroles() {
		return mroles;
	}

	public void setMroles(String mroles) {
		this.mroles = mroles;
	}

	public String getUserDepartName() {
		return userDepartName;
	}

	public void setUserDepartName(String userDepartName) {
		this.userDepartName = userDepartName;
	}

	public String getUserPosiName() {
		return userPosiName;
	}

	public void setUserPosiName(String userPosiName) {
		this.userPosiName = userPosiName;
	}

	

	public Long getUserDepartId() {
		return userDepartId;
	}

	public void setUserDepartId(Long userDepartId) {
		this.userDepartId = userDepartId;
	}

	public Long getUserPosiId() {
		return userPosiId;
	}

	public void setUserPosiId(Long userPosiId) {
		this.userPosiId = userPosiId;
	}

	public UserInfo() {
		super();
	}
	
	public UserInfo(long userId, String name, String userDepartment,
			String userPosition, long userGroupId, String userStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.userDepartment = userDepartment;
		this.userPosition = userPosition;
		this.userGroupId = userGroupId;
		this.userStatus = userStatus;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserDepartment() {
		return userDepartment;
	}
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
    
}
