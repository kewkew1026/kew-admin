package com.kew.boss.mapper;

import com.kew.boss.model.UserGroup;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserGroupMapper {
	/**
	 * 查询所有用户组
	 * @return
	 */
	 List<UserGroup> getAllUserGroup();
	
	/**
	 * 通过用户组名称查询用户组信息
	 * @param groupName
	 * @return
	 */
	 UserGroup getUserGroupByName(String groupName);
	
	/**
	 * 通过条件查询用户组信息
	 * @param groupName
	 * @return
	 */
	 List<UserGroup> getUserGroupByCondition(UserGroup userGroup, RowBounds rowBounds);
    
	/**
	 * 通过用户组ID查询用户组信息
	 * @param groupId
	 * @return
	 */
	 UserGroup getUserGroupById(long groupId);
	
	/**
	 * 新增用户组
	 * @param userGroup
	 */
	 void addUserGroup(UserGroup userGroup);
	
	/**
	 * 更新用户组信息
	 * @param userGroup
	 */
	 void updateUserGroup(UserGroup userGroup);
	
	/**
	 * 删除用户组
	 * @param groupId
	 */
	 void deleteUserGroup(long groupId);
	
	/**
	 * 查询该角色下的分配用户组
	 * @param roleId 角色ID
	 * @return
	 */
	 List<UserGroup> findByRoleUserGroup(long roleId);
	
	/**
     * 查询该角色下的未配用户组
     * @param roleId 角色ID
     * @return
     */
	 List<UserGroup> findByRoleUnUserGroup(long roleId);
	
	/**
	 * 是否可以删除用户组
	 * @param userGrpId
	 * @return
	 */
	 long isEnableDelUserGrp(long userGrpId);

	/**
	 * 按条件查询用户组总数
	 * @param userGroup
	 * @return
	 */
	 int getUserGroupTotal(UserGroup userGroup);
}
