/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * RbacService.java
 */
package com.kew.boss.service;


import com.kew.page.Page;
import com.kew.boss.model.Role;
import com.kew.boss.model.User;
import com.kew.boss.model.UserGroup;
import com.kew.boss.model.UserInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RbacService {
	
	/**
	 * 通过用户Id获得用户
	 * @param id 用户id
	 * @return 用户
	 */
	 User getUserById(long id);
	
	/**
	 * 通过用户名获得用户
	 * @param name 用户名称
	 * @return 用户
	 */
	 User getUserByName(String name);
	
	/**
	 * 新增用户
	 * @param user 用户
	 */
	 void insertUser(User user);

	/**
	 * 更新用户
	 * @param user 用户
	 */
	 void updateUser(User user);
	
	/**
	 * 更改用户密码
	 * @param userId 用户Id
	 * @param newPassword 用户密码
	 */
	 void updateUserPassword(long userId, String newPassword);
	
	/**
	 * 删除用户
	 * @param id 用户id
	 */
	 void deleteUser(long id);
	
	/**
	 * 后台操作员增加
	 * @param user 用户基本信息
	 * @param userInfo 用户属性信息
	 */
     void insertUserInfo(User user, UserInfo userInfo);
    
    /**
     * 更新用户信息
     * @param userInfo 用户属性信息
     */
     void updateUserInfo(UserInfo userInfo);
     
    /**
	 * 通过用户Id获得用户信息
	 * @param id 用户Id
	 * @return 用户信息
	 */
	 UserInfo getUserInfoById(long id);
    
    /**
     * 通过指定查询条件查询用户信息
     * @param userInfo 用户信息检索条件
     * @param rowBounds 分页对象
     * @return 用户信息
     */
    public List<UserInfo> getUserInfoByCondition(UserInfo userInfo, RowBounds rowBounds);
    
	/**
	 * 查询所有用户组
	 * @return 用户组list
	 */
	 List<UserGroup> getAllUserGroup();
	
	/**
	 * 通过用户组名称查询用户组信息
	 * @param groupName 户组名称
	 * @return 用户组信息
	 */
	 UserGroup getUserGroupByName(String groupName);
	
	/**
	 * 通过条件查询用户组信息
	 * @param userGroup 用户组名称
	 * @param rowBounds 分页对象
	 * @return 用户组信息
	 */
	 List<UserGroup> getUserGroupByCondition(UserGroup userGroup, RowBounds rowBounds);
    
	/**
	 * 通过用户组ID查询用户组信息
	 * @param groupId 用户组ID
	 * @return 用户组信息
	 */
	 UserGroup getUserGroupById(long groupId);
	
	/**
	 * 新增用户组
	 * @param userGroup 用户组
	 */
	 void addUserGroup(UserGroup userGroup);
	
	/**
	 * 更新用户组信息
	 * @param userGroup 用户组
	 */
	 void updateUserGroup(UserGroup userGroup);
	
	/**
	 * 删除用户组
	 * @param groupId 用户组id
	 */
	 void deleteUserGroup(long groupId);
	
	/**
	 * 查询所有角色
	 * @return 角色list
	 */
	 List<Role> getAllRole();
	
	/**
	 * 通过角色名查询角色
	 * @param roleName 角色名
	 * @return 角色
	 */
	 Role getRoleByName(String roleName);
	
	/**
	 * 通过条件查询角色
	 * @param role 角色
	 * @return 角色list
	 */
	 List<Role> getRoleByCondition(Role role, RowBounds rowBounds);
	
	/**
	 * 通过角色Id查找角色
	 * @param roleId 角色id
	 * @return 角色
	 */
	 Role getRoleById(long roleId);
	
	/**
	 * 增加角色
	 * @param role 角色
	 */
	 void addRole(Role role);
	
	/**
	 * 更新角色信息
	 * @param role 角色
	 */
	 void updateRole(Role role);
	
	/**
	 * 删除角色
	 * 
	 * @param roleId 角色id
	 */
	 void deleteRole(long roleId);
	
    /**
     * 查询该角色下的分配用户组
     * @param roleId 角色ID
     * @return 用户组list
     */
     List<UserGroup> findByRoleUserGroup(long roleId);
    
    /**
     * 查询该角色下的未配用户组
     * @param roleId 角色ID
     * @return 用户组list
     */
     List<UserGroup> findByRoleUnUserGroup(long roleId);
    
    /**
     * 根据用户id获取不属于该用户角色（不包含用户组继承角色）
     * 
     * @param userId
     *            用户id
     * @return 用户没有关联的角色信息list（不包含用户组继承角色）
     */
	 List<Role> getUnRloesNotGrpByUserId(long userId);
	
    /**
     * 根据用户id获取属于该用户角色（不包含用户组继承角色）
     * 
     * @param userId
     *            用户id
     * @return 用户关联的角色信息list（不包含用户组继承角色）
     */
	 List<Role> getRloesNotGrpByUserId(long userId);
	
    /**
     * 根据用户id获取属于该用户的用户组
     * 
     * @param userId
     *            用户id
     * @return 该用户的用户组list
     */
	 List<UserGroup> getUserGroupByUserId(long userId);
	
    /**
     * 根据用户id获取不属于该用户组
     * 
     * @param userId
     *            用户id
     * @return 不属于该用户的用户组list
     */
	 List<UserGroup> getUnUserGroupByUserId(long userId);
	
	/**
	 * 增加用户所属的用户组
	 * @param userId 用户组id
	 * @param userGrpIds 用户组id串
	 */
	 void editUserGroupUser(long userId, String[] userGrpIds);
	
	/**
	 * 增加用户所属的角色
	 * @param userId 用户组id
	 * @param roleIds 角色id串
	 */
	 void editUserRole(long userId, String[] roleIds);
	
	/**
	 * 是否可以删除用户组
	 * @param userGrpId 用户组id
	 * @return true：可删除 false：不可删除
	 */
	 boolean isEnableDelUserGrp(long userGrpId);
	
	/**
	 * 是否可以删除角色
	 * @param roleId 角色id
	 * @return true：可删除 false：不可删除
	 */
	 boolean isEnableDelRole(long roleId);

	/**
	 * 按条件查询用户组总数
	 * @param userGroup
	 * @return
	 */
	 int getUserGroupTotal(UserGroup userGroup);

	/**
	 * 按条件查询用户总数
	 * @param userInfo
	 * @return
	 */
	 int getUserTotal(UserInfo userInfo);

	/**
	 * 按条件查询角色总数
	 * @param userInfo
	 * @return
	 */
	 int getRoleTotal(Role role);

	/**
	 * 根据用户名密码获得用户
	 * @param username
	 * @param password
	 * @return
	 */
	 User authUser(String username, String password);

	/**
	 * 按条件查询获得分页对象
	 * @param userInfo
	 * @param rowBounds
	 * @return
	 */
	 Page<UserInfo> getPageModel(UserInfo userInfo,
                                                RowBounds rowBounds);

	/**
	 * 按条件查询获得分页对象
	 * @param role
	 * @param rowBounds
	 * @return
	 */
	 Page<Role> getPageModel(Role role, RowBounds rowBounds);

	/**
	 * 按条件查询获得分页对象
	 * @param userGroup
	 * @param rowBounds
	 * @return
	 */
	 Page<UserGroup> getPageModel(UserGroup userGroup,
                                                 RowBounds rowBounds);
	/**
	 * 更新角色下的用户组
	 * @param roleid
	 * @param groupid
	 */
	public void delFindByRoleTUserGroup(String roleid, String[] groupid);
	
	/**
	 * 根据用户ID获得所有角色(含用户组中的角色)
	 * @param userId
	 * @return
	 */
	public List<Role> getRloesByUserId(Long userId);
	
}
