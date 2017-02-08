package com.kew.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by qiudanping on 2017/1/21.
 */
public class StringUtil {

    public static Configuration configuration;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static{
        configuration = new Configuration();
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(StringUtil.class, "/");
    }

    public static String getProcessValue(Map<String, Object> contentMap, String temp) {
        try{
            Template template = new Template("", new StringReader("<#escape x as (x)!>"+temp+"</#escape>"),configuration);
            StringWriter sw = new StringWriter();
            template.process(contentMap,sw);
            return sw.toString();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
