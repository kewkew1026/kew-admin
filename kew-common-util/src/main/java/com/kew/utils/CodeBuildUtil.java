package com.kew.utils;


import com.alibaba.fastjson.JSONObject;
import com.kew.model.ModelInfo;
import com.kew.model.ProjectConfig;
import com.kew.service.impl.DateBaseServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by qiudanping on 2017/2/9.
 */
public class CodeBuildUtil {

    public static void build(String ...configFileNames) throws Exception{
        String configFileName = "/project.json";
        if(configFileNames!=null&&configFileNames.length>0&&configFileNames[0]!=null){
            configFileName = "/"+configFileNames[0]+".json";
        }
        buildBy(FileUtil.readFile(CodeBuildUtil.class.getResourceAsStream(configFileName)));
    }

    private static void buildBy(String configStr) throws IOException {

        ProjectConfig mconfig = (ProjectConfig) JSONObject.parseObject(configStr,ProjectConfig.class);
        Properties jdbcInfo = new Properties();
        jdbcInfo.load(CodeBuildUtil.class.getResourceAsStream("/jdbc.properties"));
        mconfig.setJdbcDriver(jdbcInfo.getProperty("system.jdbc.driver"));
        mconfig.setJdbcUrl(jdbcInfo.getProperty("system.jdbc.url"));
        mconfig.setJdbcUsername(jdbcInfo.getProperty("system.jdbc.username"));
        mconfig.setJdbcPassword(jdbcInfo.getProperty("system.jdbc.password"));
        List<ModelInfo> miList = new DateBaseServiceImpl().loadModelInfo(mconfig);

    }


}
