package com.kew.utils;

import java.util.Map;

/**
 * Created by qiudanping on 2017/1/20.
 */
public class FtlBuild {

    /**
     * pom ftl
     */
    private final static String PARENT_POM_FTL   =  "parent_pom.ftl";

    private final static String COMMON_POM_FTL   =  "common_pom.ftl";

    private final static String BASIE_POM_FTL    =  "basie_pom.ftl";

    private final static String CORE_POM_FTL     =  "core_pom.ftl";

    private final static String OPENAPI_POM_FTL  =  "openapi_pom.ftl";

    private final static String WEBSITE_POM_FTL  =  "website_pom.ftl";

    private final static String BOSS_POM_FTL     =  "boss_pom.ftl";

    private final static String INNERAPI_POM_FTL =  "innerapi_pom.ftl";

    private final static String MPS_POM_FTL      =  "mps_pom.ftl";


    /***
     * web xml ftl
     */
    private final static String WEBSITE_WEB_XML_FTL    =  "website_web_xml.ftl";

    private final static String BOSS_WEB_XML_FTL       =  "boss_web_xml.ftl";

    private final static String MPS_WEB_XML_FTL        =  "mps_web_xml.ftl";

    private final static String INNERAPI_WEB_XML_FTL   =  "innerapi_web_xml.ftl";

    private final static String OPENAPI_WEB_XML_FTL    =  "openapi_web_xml.ftl";

    /***
     * 生成父节点pom.xml
     * @param path 文件目录
     * @param paramMap  文件内容（待替换的结构）
     */
    public static void saveParentPom(String path, Map<String, Object> paramMap) {
        savePom(path,PARENT_POM_FTL,paramMap);
    }

    /***
     * 基方法：生成pom文件
     * @param path  生成文件路径
     * @param ftlName 待生成的文件名
     * @param paramMap 替换参数
     */
    public static void savePom(String path,String ftlName,Map<String,Object> paramMap){
        String temp = FileUtil.loadFtlBy("ftls/"+ftlName,FtlBuild.class);
        String valStr = StringUtil.getProcessValue(paramMap,temp);
        FileUtil.writeFile(path,"pom.xml",valStr);
    }

    public static void savePomByModelName(String path,String modelName,Map<String,Object> paramMap){
        String temp = FileUtil.loadFtlBy("ftls/"+modelName+"_pom.ftl",FtlBuild.class);
        String valStr = StringUtil.getProcessValue(paramMap,temp);
        FileUtil.writeFile(path,"pom.xml",valStr);
    }

    public static void saveWebXmlByModelName(String path,String modelName,Map<String,Object> paramMap){
        String temp = FileUtil.loadFtlBy("ftls/"+modelName+"_web_xml.ftl",FtlBuild.class);
        String valStr = StringUtil.getProcessValue(paramMap,temp);
        FileUtil.writeFile(path,"web.xml",valStr);
    }

}
