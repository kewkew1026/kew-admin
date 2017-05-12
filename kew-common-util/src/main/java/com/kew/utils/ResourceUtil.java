/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * ResourceUtil.java
 */
package com.kew.utils;

import java.util.Locale;
import java.util.ResourceBundle;


public class ResourceUtil {
	
	/**
	 * 隐藏构造器
	 */
	private ResourceUtil(){
		
	}
	
	/**
	 * 本地语言类型，中文 
	 */
	private static Locale locale = new Locale("zh", "CN"); 	
	
	/**
	 * 资源文件名
	 */
    private static  ResourceBundle resBundle = ResourceBundle.getBundle("resource", locale);
    

    /**
     * 从资源文件获取message
     * @author chenghong
     * @param key 资源文件里的键
     * @return  资源文件里的message
     */
    public static String  getMessage(String key){
    	return resBundle.getString(key);
    }



}
