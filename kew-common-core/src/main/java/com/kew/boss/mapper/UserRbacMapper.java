/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * UserRbacMapper.java
 */
package com.kew.boss.mapper;

import com.kew.boss.model.*;

import java.util.List;

public interface UserRbacMapper {

    /**
     * 根据loginid获取用户信息
     * 
     * @param loginId
     *            用户登录id
     * @return 用户信息
     */
	 User getUserByLoginId(String loginId);

    /**
     * 根据用户id获取用户角色（包含用户组继承的角色）
     * 
     * @param userId
     *            用户id
     * @return 用户关联的角色信息list（包含用户组继承的角色）
     */
	 List<Role> getRloesByUserId(long userId);

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
     * 删除用户所属的用户组
     * 
     * @param userId
     *            用户id
     */
	 void delUserGrpByUserId(long userId);
	
    /**
     * 删除用户所属的角色
     * 
     * @param userId
     *            用户id
     */
	 void delUserRoleByUserId(long userId);
	
    /**
     * 增加用户所属的用户组
     * 
     * @param userGroupUser
     *            用户组
     */
	 void instUserGroupUser(UserGroupUser userGroupUser);
	
    /**
     * 增加用户所属的角色
     * 
     * @param userRole
     *            角色
     */
	 void instUserRole(UserRole userRole);
}
