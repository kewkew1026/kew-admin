/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * MenueServiceImpl.java
 */
package com.kew.boss.service.impl;

import com.kew.boss.mapper.MenueMapper;
import com.kew.boss.mapper.RoleFunOptMapper;
import com.kew.boss.model.Menue;
import com.kew.boss.service.MenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenueServiceImpl implements MenueService {
	/**
	 * 菜单Mapper
	 */
	@Autowired
	private MenueMapper menueMapper;
	
	/**
	 * 角色 资源Mapper
	 */
	@Autowired
	private RoleFunOptMapper roleFunOptMapper;

	/**
	 * 获取所有的菜单
     * @return 所有的菜单
	 */
	@Transactional(readOnly = true)
	public  List<Menue> getMenueList(){
		return menueMapper.getMenueList();
	}
	
	/**
	 * 获取菜单树 将数据库中菜单节点封装到菜单树形结构
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
     * @return 菜单树
	 */
	@Transactional(readOnly = true)
	public Menue getMenueDoc(boolean mainTreeFlg){
		List<Menue> menueList = menueMapper.getMenueList();
		Map<Long,Menue> menueMap = new HashMap<Long,Menue>();
		for(Menue menue: menueList){
			menueMap.put(menue.getMenueId(), menue);
		}
		Menue returnMenue = null;
		for(Menue menue: menueList){
			
			//菜单管理特殊节点
//			if(!mainTreeFlg 
//					&& menue.getMenueId() == Long.parseLong(SysConstants.SYS_MENUE_ID))
//			{
//				continue;
//			}
			
			//非根结点
			if(menue.getParMenueId() != 0){
				Menue parMenue = menueMap.get(menue.getParMenueId());
				if(parMenue.getChildrenMenueList() == null){
					parMenue.setChildrenMenueList(new ArrayList<Menue>());
					parMenue.getChildrenMenueList().add(menue);
				}
				else{
					// 排序插入
					boolean insertFlg = false;
					for(int i = 0; i < parMenue.getChildrenMenueList().size(); i++){
						if(parMenue.getChildrenMenueList().get(i).getMenueOrder()
								> menue.getMenueOrder()){
							parMenue.getChildrenMenueList().add(i,menue);
							insertFlg =true;
							break;
						}
					}
					if(!insertFlg){
						parMenue.getChildrenMenueList().add(menue);
					}
				}
			}
			else{
				returnMenue = menue;
			}
		}
		return returnMenue;
	}
	
	 /**
	 * 获取菜单树 将数据库中菜单节点封装到菜单树形结构
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
	 * @param funOpIds
     * @return 菜单树
	 */
    private Menue getMenueDoc(boolean mainTreeFlg, List<Long> funOpIds,String username) {
    	List<Menue> menueList = menueMapper.getMenueList();
    	
    	//如果是左边显示菜单(mainTreeFlg==true) 将不符合用户的菜单去掉
    	if(mainTreeFlg){
    		menueList = filter(menueList,funOpIds);
    	}
    	
		Map<Long,Menue> menueMap = new HashMap<Long,Menue>();
		for(Menue menue: menueList){
			menueMap.put(menue.getMenueId(), menue);
		}
		Menue returnMenue = null;
		for(Menue menue: menueList){
			
			//菜单管理特殊节点
//			if(!mainTreeFlg 
//					&& menue.getMenueId() == Long.parseLong(SysConstants.SYS_MENUE_ID))
//			{
//				continue;
//			}
			
			//非根结点
			if(menue.getParMenueId() != 0){
				Menue parMenue = menueMap.get(menue.getParMenueId());
				if(parMenue!=null){
					if(parMenue.getChildrenMenueList() == null){
						parMenue.setChildrenMenueList(new ArrayList<Menue>());
						parMenue.getChildrenMenueList().add(menue);
					}
					else{
						// 排序插入
						boolean insertFlg = false;
						for(int i = 0; i < parMenue.getChildrenMenueList().size(); i++){
							if(parMenue.getChildrenMenueList().get(i).getMenueOrder()
									> menue.getMenueOrder()){
								parMenue.getChildrenMenueList().add(i,menue);
								insertFlg =true;
								break;
							}
						}
						if(!insertFlg){
							parMenue.getChildrenMenueList().add(menue);
						}
					}
				}
			}
			else{
				returnMenue = menue;
			}
		}
		
		//如果是左边显示菜单(mainTreeFlg==true) 过滤掉单叶子节点的菜单
		if(mainTreeFlg){
			returnMenue = filter(returnMenue,username,mainTreeFlg);
		}
		return returnMenue;
	}
    
    /**
     * 过滤掉单第一层叶子节点的菜单
     * @param returnMenue
     * @param username
     * @param mainTreeFlg
     * @return
     */
    private Menue filter(Menue returnMenue,String username,boolean mainTreeFlg) {
    	List<Menue> list = returnMenue.getChildrenMenueList();
    	
    	List<Menue> myList = new ArrayList<Menue>();
    	myList.addAll(list);
    	
    	int size = list.size();
    	for(int i=0;i<size;i++){
    		Menue child = list.get(i);
    		if(child!=null){
    			
    			//如果该节点是第一循环节点 并且没孩子节点
    			if(child.getChildrenMenueList()==null || child.getChildrenMenueList().size()==0){
    				
    				//如果该节点是菜单管理节点
    				//if(SysConstants.MENUE_MANAGE.equals(child.getMenueNm())){
    					
    					//如果用户登录名称不是所配置的菜单管理员 则不允许显示菜单管理节点
//    					if(!SysConstants.MENUE_MANAGER.equals(username)){
//    						myList.remove(child);
//    						continue;
//    					}else{
//    						continue;
//    					}
    				//}
    				//if(!SysConstants.MENUE_MANAGER.equals(username)){
    				//	myList.remove(child);
    				//}
    				
    				//如果不是菜单管理命令触发的请求 则去掉没孩子节点的节点
    				if(mainTreeFlg){
    					myList.remove(child);
    			    }
    				
    				//myList.remove(child);
    				
    			}
    		}
    	}
    	
    	returnMenue.setChildrenMenueList(myList);
		return returnMenue;
	}

	/**
     * 将不符合用户要求的菜单去掉
     * @param menueList
     * @param funOpIds
     * @return
     */
	private List<Menue> filter(List<Menue> menueList, List<Long> funOpIds) {
		
		List<Menue> myList = new ArrayList<Menue>();
		myList.addAll(menueList);
		
		int size = menueList.size();
		for(int i=0;i<size;i++){
			Menue menue = menueList.get(i);
			long funOptId = menue.getFunOptId();
			
//			if(!funOpIds.contains(funOptId)){
//				myList.remove(menue);
//			}
			
			if(!funOpIds.contains(funOptId) && funOptId!=0L){
				myList.remove(menue);
			}
			
			//如果是无效菜单 删除
			if("0".equals(menue.getState())){
				myList.remove(menue);
			}
		}
//		for(int i=0;i<menueList.size();i++){
//			System.out.println(menueList.get(i).getFunOptId()+":"+menueList.get(i).getMenueNm());
//		}
		return myList;
	}

	/**
	 * 根据菜单id获取菜单
	 * @param menueId 菜单id
     * @return 菜单
	 */
	public Menue srchMenue(long menueId){
		return menueMapper.srchMenue(menueId);
	}
	
	/**
	 * 插入菜单
	 * @param menue 菜单
	 */
	public  void insertMenue(Menue menue){
		menueMapper.insertMenue(menue);
	}
	
	/**
	 * 更新菜单
	 * @param menue 菜单
	 */
	public  void updateMenue(Menue menue){
		menueMapper.updateMenue(menue);
	}
	
	/**
	 * 删除菜单
	 * @param menueId 菜单id
	 */
	public void delMenue(long menueId){
		menueMapper.delMenue(menueId);
	}
	
	/**
	 * 菜单树生成html文字串
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
     * @return html文字串
	 */
    public String menuDataAdaptor(boolean mainTreeFlg)
    {
    	//从session中获取用户对应的资源
    	return menueDocToStr(getMenueDoc(mainTreeFlg).getChildrenMenueList()); 
    }
    
	/**
	 * 将子菜单list转换成html文字串
	 * @param childrenMenueList 子菜单
     * @return html文字串
	 */
    private String menueDocToStr(List<Menue> childrenMenueList){
    	//is属性 1为非根节点 0为根节点
        StringBuilder sb = new StringBuilder("<ul style='background-color:#F0F8FF;'>");
        if (childrenMenueList != null && childrenMenueList.size() > 0)
        {
            for(Menue menue:childrenMenueList)
            {
            	String menueUrl = menue.getMenueUrl();
            	menueUrl = (menueUrl == null)? "":menueUrl;
                if(menue.getChildrenMenueList()!=null&&menue.getChildrenMenueList().size()>0)
                {
                	sb.append("<li id='" + menue.getMenueId()
                			+ "' is='1' url='" + menueUrl + "' parentid='"+ menue.getParMenueId() +"' style='background-color:#F0F8FF;'>");
                }
                else
                {
                	sb.append("<li id='" + menue.getMenueId()
                			+ "' is='0' url='" + menueUrl + "' parentid='"+ menue.getParMenueId() +"' style='background-color:#F0F8FF;'>");
                }
                sb.append("<a href='#'>"+menue.getMenueNm()+"</a>");
                if(menue.getChildrenMenueList()!=null&&menue.getChildrenMenueList().size()>0)
                {
                	sb.append(menueDocToStr(menue.getChildrenMenueList()));
                }
                sb.append("</li>");
            }
        }
        sb.append("</ul>");
        return sb.toString();
    }
    
	/**
	 * 根据资源id查询引用该资源的菜单list
	 * @param funOptId 资源id
     * @return html文字串
	 */
    @Transactional(readOnly = true)
    public List<Menue> findByFunOptId(long funOptId)
    {
        return menueMapper.findByFunOptId(funOptId);
    }
    
	/**
     * 根据资源id判断改资源是否被菜单引用
     * @param funOptId
     *            资源id
     * @return true:被引用,false:未被引用
     */
    @Transactional(readOnly = true)
    public boolean isNull(long funOptId)
    {
        List<Menue> list = findByFunOptId(funOptId);
        if(list!=null&&list.size()>0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
	 * 菜单树生成html文字串
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
	 * @param roleIds
	 * @param username
     * @return html文字串
	 */
    @Transactional(readOnly = true)
	public Object menuDataAdaptor(boolean mainTreeFlg, List<Long> roleIds,String username) {
		List<Long> funOpIds = roleFunOptMapper.getFunOptByRoleIds(roleIds);
		return menueDocToStr(getMenueDoc(mainTreeFlg,funOpIds,username).getChildrenMenueList()); 
	}
	
	/**
	 * 得到根Menu生成菜单
	 * @param mainTreeFlg true：主页左边的主菜单，false：进行菜单维护的菜单页面
	 * @param roleIds
	 * @param username
     * @return List<Menue>
	 */
    @Transactional(readOnly = true)
	public Menue getRootMenue(boolean mainTreeFlg, List<Long> roleIds,String username){
		if(roleIds==null ||roleIds.size()==0){
			return null;
		}
		List<Long> funOpIds = roleFunOptMapper.getFunOptByRoleIds(roleIds);
		return getMenueDoc(mainTreeFlg,funOpIds,username);
	}
	
	/**
	 * 得到除根节点外所有菜单list
	 * @param mainTreeFlg
	 * @param roleIds
	 * @param username
	 * @return
	 */
    @Transactional(readOnly = true)
	public List<Menue> getMenueList(boolean mainTreeFlg, List<Long> roleIds,String username){
		List<Long> funOpIds = roleFunOptMapper.getFunOptByRoleIds(roleIds);
		return getMenueDoc(mainTreeFlg,funOpIds,username).getChildrenMenueList();
	}

	/**
	 * 判断当前节点菜单号是否合法
	 * @param menue
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean isValideNumber(Menue menue) {
		boolean isValide = true;
		int number = menueMapper.findNumber(menue);
		if(number > 0){
			isValide = false;
		}
		return isValide;
	}

	/**
	 * 判断当前节点菜单号是否合法(修改时用)
	 * @param menue
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean isValideNumberEdit(Menue menue) {
		boolean isValide = true;
		int number = menueMapper.findNumberEdit(menue);
		if(number > 0){
			isValide = false;
		}
		return isValide;
	}
	
}
