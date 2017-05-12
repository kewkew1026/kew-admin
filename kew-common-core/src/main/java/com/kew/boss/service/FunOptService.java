package com.kew.boss.service;

import com.kew.page.Page;
import com.kew.boss.model.FunOpt;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface FunOptService 
{
	/**
     * 获得所有资源列表
     * @return 获得所有资源列表结果集
     */
     List<FunOpt> data();

    /**
     * 通过主键查找当前资源
     * @param o
     * @return
     */
     FunOpt findById(Object o);

    /**
     * 添加资源
     * @param entity
     */
     void add(FunOpt entity);

    /**
     * 更新资源
     * @param entity
     */
     void update(FunOpt entity);

    /**
     * 删除资源
     * @param entity
     */
     void del(FunOpt entity);

    /**
     * 查询角色未分配功能
     * @param roleId 角色ID
     * @return
     */
     List<FunOpt> findByRoleUnFunOpt(long roleId);

    /**
     * 查询角色已分配功能
     * @param roleId 角色ID
     * @return
     */
     List<FunOpt> findByRoleFunOpt(long roleId);

	/**
     * 按条件查询资源列表
     * @return 按条件查询资源列表
     */
	 List<FunOpt> getFunOptByCondition(FunOpt funOpt, RowBounds rb);

	/**
	 * 根据条件查询总行数
	 * @return
	 */
	 int getTotal(FunOpt funOpt);
	
	/**
	 * 根据用户id查询URL
	 * @return
	 */
	public List<String> getFunOptUrlByUserId(long userId);

	/**
	 * 查询得到分页对象
	 * @param funOpt
	 * @param rowBounds
	 * @return
	 */
	 Page<FunOpt> getPageModel(FunOpt funOpt, RowBounds rowBounds);

	/**
	 * 判断是否能删除该资源
	 * @param funOpt
	 * @return true可以删除 false不能删除
	 */
	 boolean isCouldDelete(FunOpt funOpt);
	
	/**
	 * 根据URL查找资源
	 */
	 FunOpt getByUrl(String url);

	/**
	 * 判断是否有效url
	 * @param url
	 * @return
	 */
	 boolean isValidUrl(String url);

	/**
	 * 判断是否有效url
	 * @param url
	 * @param funOptId
	 * @return
	 */
	 boolean isValidUrl(String url, long funOptId);

}
