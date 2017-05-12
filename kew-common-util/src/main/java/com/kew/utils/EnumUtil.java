package com.kew.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by qiudanping on 2017/4/27.
 */
public class EnumUtil {

    private static Logger logger = LoggerFactory.getLogger(EnumUtil.class);
    public static Map<String,Enum<?>[]> ENUMS_TO_VIEW = new HashMap<String, Enum<?>[]>();
    /**
     * @param enu 枚举实例
     * @return 该枚举的子枚举类型
     */
    public static Enum<?>[] getChild(Enum<?> enu){
        try {
            List<Enum<?>> mList = new ArrayList<Enum<?>>();
            Enum<?>[] menums = (Enum<?>[])invoke("values",enu,null,null);
            for(int i=0;i<menums.length;i++){
                Enum<?> menu = (Enum<?>)invoke("getParent",menums[i],null,null);
                if(enu.equals(menu)){
                    mList.add(menums[i]);
                }
            }
            return mList.toArray(new Enum<?>[mList.size()]);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @param code 目标枚举的code
     * @param enu 该枚举的任意枚举类型
     */
    public static Enum<?> parse(String code,Enum<?> enu){
        try {
            Enum<?>[] menums = (Enum<?>[])invoke("values",enu,null,null);
            for(int i=0;i<menums.length;i++){
                String mno = (String)invoke("getCode",menums[i],null,null);
                if(code.equals(mno)){
                    return menums[i];
                }
            }
        } catch (Exception e){
        }
        return null;
    }

    /**
     * @param no 目标枚举的NO
     * @return menums
     */
    public static Enum<?> parse(String no,Enum<?>[] menums){
        try {
            for(int i=0;i<menums.length;i++){
                String mno = (String)invoke("getCode",menums[i],null,null);
                if(no.equals(mno)){
                    return menums[i];
                }
            }
        } catch (Exception e){
        }
        return null;
    }

    public static String getDes(String no,Enum<?> enu){
        try {
            Enum<?>[] menums = (Enum<?>[])invoke("values",enu,null,null);
            for(int i=0;i<menums.length;i++){
                String mno = (String)invoke("getCode",menums[i],null,null);
                if(no.equals(mno)){
                    return (String)invoke("getDes",menums[i],null,null);
                }
            }
        } catch (Exception e){
        }
        return null;
    }

    public static Object invoke(String method,Object obj,Class<?>[] argTypes,Object[] args) throws Exception{
        Method m = obj.getClass().getMethod(method,argTypes);
        return m.invoke(obj,args);
    }

    public static JSONArray toJsonArray(Enum<?>[] enus, boolean isMy, boolean haveAll){
        JSONArray enusja = new JSONArray();
        try {
            if(haveAll){
                JSONObject enujo = new JSONObject();
                enujo.put("name","");
                enujo.put("des","-请选择-");
                enusja.add(enujo);
            }
            for (Enum<?> enu : enus) {
                JSONObject enujo = new JSONObject();
                enujo.put("name",(isMy?enu.toString():(String)invoke("getCode",enu,null,null)));
                enujo.put("des",(String)invoke("getDes",enu,null,null));
                enusja.add(enujo);
            }
        } catch (Exception e) {
            logger.error("枚举转换JSONArray错误",e);
        }
        return enusja;
    }

    public static JSONArray toJsonTree(Enum<?>[] enus,boolean isRoot,boolean isMy){
        JSONArray enusja = new JSONArray();
        if(isRoot){
            JSONObject all = new JSONObject();
            all.put("id","-2");
            all.put("text","");
            enusja.add(all);
        }
        try {
            for (Enum<?> enu : enus){
                if(!isRoot||invoke("getParent",enu,null,null)==null){
                    JSONObject enujo = new JSONObject();
                    enujo.put("id",(isMy?enu.toString():(String)invoke("getCode",enu,null,null)));
                    enujo.put("text",(String)invoke("getDes",enu,null,null));
                    Enum<?>[] childs = getChild(enu);
                    if(childs!=null&&childs.length>0){
                        enujo.put("id","-1");
                        enujo.put("children",toJsonTree(childs,false,isMy));
                    }
                    enusja.add(enujo);
                }
            }
        } catch (Exception e) {
            logger.error("枚举转换JSONArray错误",e);
        }
        return enusja;
    }

    public static JSONObject toCombo(Enum<?>[] enus,boolean isMy){
        JSONObject o = new JSONObject();
        o.put("data",toJsonArray(enus,isMy,false));
        o.put("treeData",toJsonTree(enus,true,isMy));
        o.put("valueField","name");
        o.put("textField","des");
        return o;
    }
    /**
     * 默认添加一个请选择
     * @param enus
     * @param isMy
     * @param isAll
     * @return
     */
    public static JSONObject toCombo(Enum<?>[] enus,boolean isMy,boolean haveAll){
        JSONObject o = new JSONObject();
        o.put("data",toJsonArray(enus,isMy,haveAll));
        o.put("valueField","name");
        o.put("textField","des");
        return o;
    }

    public static JSONObject loadCommonCategorys(){
        JSONObject commonCategorys = new JSONObject();
        //用户类型

        for (Map.Entry<String,Enum<?>[]> mentry : ENUMS_TO_VIEW.entrySet()) {
            commonCategorys.put(mentry.getKey(),toCombo(mentry.getValue(),false));
        }
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(new File(EnumUtil.class.getResource("/enums_info.properties").getPath())));
            for (Map.Entry<Object,Object> mentry : p.entrySet()) {
                String key = (String)mentry.getKey();
                String className = (String)mentry.getValue();
                try{
                    @SuppressWarnings("unchecked")
                    Class<Enum<?>> menum = (Class<Enum<?>>)Class.forName(className);
                    commonCategorys.put(key,toCombo((Enum<?>[])menum.getMethod("values").invoke(null),false));
                }catch(Exception ex){
                    logger.error("枚举转换json异常:"+key+":"+className);
                }
            }
        } catch (Exception e) {
            logger.warn("枚举转换json异常:读取配置枚举配置文件异常");
        }
        return commonCategorys;
    }

    public static String loadCommonCategorysStr(){
        return loadCommonCategorys().toJSONString();
    }

}
