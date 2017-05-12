package com.kew.boss.mapper;


import com.kew.boss.model.FunOpt;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface FunOptMapper
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
     * @param roleid 角色ID
     * @return
     */
     List<FunOpt> findByRoleUnFunOpt(long roleId);

    /**
     * 查询角色已分配功能
     * @param roleid 角色ID
     * @return
     */
     List<FunOpt> findByRoleFunOpt(long roleId);

    /**
     * 按条件查询资源列表
     * @return 按条件查询资源列表
     */
	 List<FunOpt> findFunOptByFunOpt(FunOpt funOpt, RowBounds rowBounds);

	/**
	 * 获取总行数
	 * @return
	 */
	 int getTotal();

	/**
	 * 根据条件查询总行数
	 * @param funOpt
	 * @return
	 */
	 int getTotal(FunOpt funOpt);
	
	/**
	 * 根据用户id查询URL
	 * @return
	 */
	 List<String> getFunOptUrlByUserId(long userId);

	/**
	 * 判断是否能删除该资源
	 * @param funOpt
	 * @return true可以删除 false不能删除
	 */
	 long isCouldDelete(long funOptId);
	
	/**
	 * 根据URL查找资源
	 */
	 FunOpt getByUrl(String url);

	/**
	 * 根据URL查找资源 不是该资源id
	 * @param url
	 * @param funOptId
	 * @return
	 */
	 FunOpt getByUrlNotFunOptId(String url, long funOptId);
}
