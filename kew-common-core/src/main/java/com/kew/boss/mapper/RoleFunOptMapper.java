package com.kew.boss.mapper;

import com.kew.boss.model.FunRole;

import java.util.List;

public interface RoleFunOptMapper {
	
	 List<FunRole> selectAllRoleFun();
	
	/**
	 * 通过roleId的list得到资源list
	 * @param roleIds
	 * @return
	 */
	 List<Long> getFunOptByRoleIds(List<Long> roleIds);

}
