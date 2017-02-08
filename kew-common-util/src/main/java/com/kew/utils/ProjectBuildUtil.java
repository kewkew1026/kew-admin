package com.kew.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目生成器
 * 功能：生成ssm项目
 * Created by qiudanping on 2017/1/18.
 */
public class ProjectBuildUtil {

    /***
     * 项目根目录
     ***/
    private static String parentPath;

    /***
     * 所支持生成的项目
     */
    private static String []models={"common","api","basic","core","innerapi","openapi","mps","website","boss","cms"};


    public  static void main(String []configFileNames){
        String separator= File.separator;

        String configFileName=separator+"package.json";

        if(configFileNames!=null&&configFileNames.length>0&&configFileNames[0]!=null){
            configFileName = separator+configFileNames[0]+".json";
        }

        String configStr = FileUtil.readFile(ProjectBuildUtil.class.getResourceAsStream(configFileName));

        JSONObject config = JSONObject.parseObject(configStr);
        //定义循环参数和文件名
        config.put("escape", "$");
        config.put("ftl", ".ftl");

        //定义项目目录
        config.put("modelName", config.getString("groupId").toUpperCase());

        String groupId = config.getString("groupId");

        //输出目录,以.结尾
        String apath = ".";

        //截取目录
        parentPath = apath.substring(0,apath.length()-1);

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("c",config);
        FtlBuild.saveParentPom(parentPath+separator, paramMap);

        //生成子项目
        for (String mname:models) {
            String modelName = "kew-"+groupId+"-"+mname;
            List<String> dirs = new ArrayList<String>();
            dirs.add(parentPath+separator+modelName+separator+"src"+separator+"main"+separator+"java"+separator);
            dirs.add(parentPath+separator+modelName+separator+"src"+separator+"main"+separator+"resources"+separator);
            dirs.add(parentPath+separator+modelName+separator+"src"+separator+"test"+separator+"java"+separator);
            dirs.add(parentPath+separator+modelName+separator+"src"+separator+"test"+separator+"resources"+separator);
            for (String dirPath : dirs) {
                FileUtil.mkdir(dirPath);
            }

            FileUtil.batchProcess("ftls"+separator+mname+"_ftls",parentPath+separator+modelName,paramMap);
        }
    }

}
