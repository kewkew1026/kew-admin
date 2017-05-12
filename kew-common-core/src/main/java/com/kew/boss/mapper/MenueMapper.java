/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * MenueMapper.java
 */
package com.kew.boss.mapper;



import com.kew.boss.model.Menue;

import java.util.List;


public interface MenueMapper {    
	/**
     * 获取所有的菜单
     * @return 菜单
     */
	 List<Menue> getMenueList();
	
	/**
     * 查询一个菜单
     * @param menueId
     *            菜单id
     * @return 菜单
     */
	 Menue srchMenue(long menueId);
	
	/**
     * 创建菜单
     * @param menue
     *            菜单
     */
	 void insertMenue(Menue menue);
	
	/**
     * 更新菜单
     * @param menue
     *            菜单
     */
	 void updateMenue(Menue menue);
	
	/**
     * 更新菜单
     * @param menueId
     *            菜单id
     */
	 void delMenue(long menueId);
	
	/**
     * 根据资源id查询菜单
     * @param funOptId
     *            资源id
     * @return 菜单list
     */
     List<Menue> findByFunOptId(long funOptId);
    
	/**
     * 根据资源id判断改资源是否被菜单引用
     * @param funOptId
     *            资源id
     * @return true:被引用,false:未被引用
     */
     boolean isNull(long funOptId);

    /**
     * 查找序号
     * @param menue
     * @return
     */
	 Integer findNumber(Menue menue);

	/**
	 * 查找序号 排除自己
	 * @param menue
	 * @return
	 */
	 int findNumberEdit(Menue menue);
}
