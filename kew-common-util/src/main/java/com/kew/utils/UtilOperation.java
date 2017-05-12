/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * UtilOperation.java
 */
package com.kew.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;


/**
 * [文件名称]<br>
 * UtilOperation <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-12 ver1.00 创建 chenghong<br>
 * 
 * @author chenghong
 * @version 1.00
 */
public class UtilOperation {

	/**
	 * 构造方法
	 */
	private UtilOperation(){
		
	}
	/**
	 * MD5加密
	 * 
	 * @author chenghong 
	 * @param src 需要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String getMD5(String src) {
		return DigestUtils.md5DigestAsHex(src.getBytes());
	}
	
	
	/**
	 * 根据信息码获取错误信息
	 * 
	 * @author chenghong 
	 * @param errorCode 错误码
	 * @return 错误信息
	 */
	public static String  getErrorMessage(String errorCode){
		String errorMsg =  ResourceUtil.getMessage("message."+errorCode);		
		if(StringUtils.isEmpty(errorMsg)){
			errorMsg= "系统错误，请联系管理员" ;
		}		
		return errorMsg;
	}
	
	/**
	 * 根据信息码获取提示信息
	 * 
	 * @author chenghong 
	 * @param errorCode 错误码
	 * @return 错误提示信息
	 */
	public static String getMessage(String errorCode){
		String errorMsg = getErrorMessage(errorCode);
		return "{\"success\":false,\"message\":\""+errorMsg+"\"}";		
	}
	
	/**
	 * 生成session key
	 * @return session key
	 */
	public static String  createUniqueKey(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获得缓存有效期
	 * @author chenghong
	 * @return 缓存有效期
	 */
	public static int getExpiredTime(){
		return Integer.parseInt(ConfigUtil.getConfig("expiredTime","3600"));
	}
	
}
