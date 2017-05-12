/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * MenueService.java
 */
package com.kew.boss.service;

import com.kew.boss.model.Menue;

import java.util.List;

public interface MenueService {
	
	/**
	 * 获取所有的菜单
     * @return 所有的菜单
	 */
	 List<Menue> getMenueList();
	
	/**
	 * 获取菜单树
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
     * @return 菜单树
	 */
	 Menue getMenueDoc(boolean mainTreeFlg);
	
	/**
	 * 根据菜单id获取菜单
	 * @param menueId 菜单id
     * @return 菜单
	 */
	 Menue srchMenue(long menueId);
	
	/**
	 * 插入菜单
	 * @param menue 菜单
	 */
	 void insertMenue(Menue menue);
	
	/**
	 * 更新菜单
	 * @param menue 菜单
	 */
	 void updateMenue(Menue menue);
	
	/**
	 * 删除菜单
	 * @param menueId 菜单id
	 */
	 void delMenue(long menueId);
	
	/**
	 * 菜单树生成html文字串
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
     * @return html文字串
	 */
	 String menuDataAdaptor(boolean mainTreeFlg);
	
	/**
	 * 根据资源id查询引用该资源的菜单list
	 * @param funOptId 资源id
     * @return html文字串
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
	 * 菜单树生成html文字串
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
	 * @param roleIds
	 * @param username
     * @return html文字串
	 */
	 Object menuDataAdaptor(boolean b, List<Long> roleIds, String username);
	
	/**
	 * 得到根Menu生成菜单
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
	 * @param roleIds
	 * @param username
     * @return List<Menue>
	 */
	 Menue getRootMenue(boolean mainTreeFlg, List<Long> roleIds, String username);
	
	/**
	 * 得到除根节点外所有菜单list
	 * @param mainTreeFlg
	 * @param roleIds
	 * @param username
	 * @return
	 */
	public List<Menue> getMenueList(boolean mainTreeFlg, List<Long> roleIds, String username);

	/**
	 * 判断当前节点菜单号是否合法
	 * @param menue
	 * @return
	 */
	 boolean isValideNumber(Menue menue);

	/**
	 * 判断当前节点菜单号是否合法(修改时用)
	 * @param menue
	 * @return
	 */
	 boolean isValideNumberEdit(Menue menue);
}
