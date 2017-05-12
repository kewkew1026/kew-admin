package com.kew.boss.mapper;


import com.kew.boss.model.Role;
import com.kew.boss.model.RoleTUserGroup;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RoleMapper {
	/**
	 * 查询所有角色
	 * @return
	 */
	 List<Role> getAllRole();
	
	/**
	 * 通过角色名查询角色
	 * @param roleName
	 * @return
	 */
	 Role getRoleByName(String roleName);

	/***
	 * 通过条件查询角色
	 * @param role
	 * @param rowBounds
	 * @return
	 */
	 List<Role> getRoleByCondition(Role role, RowBounds rowBounds);
	
	/**
	 * 通过角色Id查找角色
	 * @return
	 */
	 Role getRoleById(long roleId);
	
	/**
	 * 增加角色
	 * @param role
	 */
	 void addRole(Role role);
	/**
	 * 更新角色信息
	 * @param role
	 */
	 void updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId
	 */
	 void deleteRole(long roleId);
	
	/**
	 * 是否可以删除角色
	 * @param roleId
	 * @return
	 */
	 long isEnableDelRole(long roleId);

	/**
	 * 根据条件查询角色总数
	 * @param role
	 * @return
	 */
	 int getRoleTotal(Role role);
	
	 /**
     * 添加
     * @param entity
     */
     void add(RoleTUserGroup entity);
    
    /**
     * 删除
     * @param roleId
     */
     void del(Integer roleId);
}
