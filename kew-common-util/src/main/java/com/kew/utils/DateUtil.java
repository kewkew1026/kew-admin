/*
 * Copyright (C) 2011 kedou All Rights Reserved.
 * 
 * DateUtil.java
 */
package com.kew.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	
	/**
	 * 构造文件隐藏
	 */
	private DateUtil() {
		
	}
    /**
     * 日期格式
     */
    public static final String DATESTYLE_LONG = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE_1 = "yyyyMMdd";

	/**
	 * 将日期转换成指定格式的字符串
	 * @param date 日期
	 * @param style 日期格式
     * @return 指定格式的字符串
	 */
    public static String dateToString(Date date, String style) {
        SimpleDateFormat dFmt = new SimpleDateFormat(style);
        return dFmt.format(date);
    }
    
    public static String todayDateStr(){
    	Date date = Calendar.getInstance().getTime();
    	SimpleDateFormat dFmt = new SimpleDateFormat(DATE);
        return dFmt.format(date);
    }
    
    public static String todayDateStr1(){
    	Date date = Calendar.getInstance().getTime();
    	SimpleDateFormat dFmt = new SimpleDateFormat(DATE_1);
    	return dFmt.format(date);
    }
}