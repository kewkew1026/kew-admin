package com.kew.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件处理
 * Created by qiudanping on 2017/1/20.
 */
public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /***
     * 通过输入文件流获取文件内容
     * @param in
     * @return 文件流中的文件内容
     */
    public  static String readFile(InputStream in){
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sb.append(temp+"\r\n");
            }
        }catch (FileNotFoundException e) {
            logger.error("读取文件失败，文件不存在:", e);
        }catch (IOException e) {
            logger.error("读取文件失败", e);
        }finally{
            if (null != br) {
                try {
                    br.close();
                }catch(IOException e){
                    logger.error("关闭文件", e);
                }
            }
        }
        return sb.toString();
    }

    /***
     * 生成指定目录
     * @param dirPath 待生成的目录
     */
    public static void mkdir(String dirPath) {
        try {
            File pex = new File(dirPath);
            if(!pex.exists()){
                if(!pex.mkdirs()){
                    throw new Exception("创建目录失败,是否合法") ;
                }
            }
        } catch (Exception e) {
            logger.error("保存或创建文件失败", e);
        }
    }

    /***
     * 自动解析当前目录中的ftl文件（支持至树叶目录）
     * @param searchFile
     * @param resFiles
     * @return
     */
    public static List<File> listFiles(File searchFile,List<File> resFiles){
        if(resFiles==null){
            resFiles = new ArrayList<File>();
        }
        File[] files =  searchFile.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                listFiles(file,resFiles);
            }else if(file.isFile()&&file.getName().endsWith(".ftl")){
                resFiles.add(file);
            }
        }
        return resFiles;
    }

    /***
     * 自动解析当前目录中的ftl文件支持至树叶目录）
     * @param file
     * @return 返回目录中的ftl文件
     */
    public static List<File> listFiles(File file){
        return listFiles(file,null);
    }

    /***
     * 加载文件内容(ftl)
     * @param absolutePath
     * @param ftlBuildClass
     * @return
     */
    private static String loadFtlStr(String absolutePath, Class<FtlBuild> ftlBuildClass) {
        try {
            return readFile(loadFtlFile(absolutePath,ftlBuildClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 加载ftl文件
     * @param path
     * @param cls
     * @return
     * @throws Exception
     */
    public static InputStream loadFtlFile(String path,Class<?> cls) throws Exception{
        InputStream is  = null;
        File f = new File(path);
        if(!f.exists()){
            is = cls.getResourceAsStream(path);
        }else{
            is = new FileInputStream(f);
        }
        return is;
    }

    public static void writeFile(String filePath, String fileName, String valStr) {
        FileOutputStream out = null;
        try {
            File pex = new File(filePath);
            if(!pex.exists()){
                if(!pex.mkdirs()){
                    throw new Exception("创建文件失败,请检查路径") ;
                }
            }
            if(StringUtils.isEmpty(fileName)){
                return;
            }
            File file = new File(filePath+fileName);
            if(file.exists()){
                file.delete();
            }
            if(!file.createNewFile()){
                throw new Exception("创建文件失败,请检查路径") ;
            }
            out= new FileOutputStream(file,true);
            out.write(valStr.getBytes("UTF-8"));
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.error("保存或创建文件失败", e);
        }finally{
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("创建文件失败,请检查路径",e);
                }
            }
        }
    }

    /***
     * 批量生成文件
     * @param sourcePath
     * @param targetPath
     * @param contentMap
     */
    public static void batchProcess(String sourcePath, String targetPath, Map<String, Object> contentMap) {
        URL ftlURL = FileUtil.class.getClassLoader().getResource(sourcePath);
        if(ftlURL==null){
            return;
        }
        String ftlPath = FileUtil.class.getClassLoader().getResource(sourcePath).getPath();
        File ftlDir = new File(ftlPath);
        List<File> listFiles = listFiles(ftlDir);
        String modelName=((JSONObject)contentMap.get("c")).getString("modelName");
        String groupId=((JSONObject)contentMap.get("c")).getString("groupId");
        for (File file : listFiles) {
            String ftlFileName = file.getName();
            String fileName    = ftlFileName.replace(".ftl", "").replace("modelName",modelName);
            String ftlFilePath = file.getAbsolutePath().replace("groupId", groupId);
            String[] mFilePath = ftlFilePath.split(sourcePath);
            if(mFilePath.length!=2){
                mFilePath = ftlFilePath.split(sourcePath.replace("/","\\\\"));
            }
            String filePath = targetPath+mFilePath[1].replace(ftlFileName,"");

            String temp = FileUtil.loadFtlStr(file.getAbsolutePath(),FtlBuild.class);
            String valStr = StringUtil.getProcessValue(contentMap,temp);

            FileUtil.writeFile(filePath,fileName,valStr);
        }
    }

    public static String loadFtlBy(String path,Class<?> cls){
        try {
            return readFile(loadFtl(path,cls));
        } catch (Exception e) {
            System.out.println(path);
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream loadFtl(String path,Class<?> cls) throws Exception{
        InputStream is  = null;
        File f = new File(path);
        if(!f.exists()){
            is = cls.getClassLoader().getResourceAsStream(path);
        }else{
            is = new FileInputStream(f);
        }
        return is;
    }
}
