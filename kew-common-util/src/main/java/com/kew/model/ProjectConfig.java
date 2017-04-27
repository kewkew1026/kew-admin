package com.kew.model;

import java.util.Map;
import java.util.Properties;

/**
 * Created by qiudanping on 2017/2/9.
 * 项目生成的配置信息
 */
public class ProjectConfig {

    /***
     *
     */
    private String model;

    /***
     * 基础包名
     */
    private String basePackage;

    /***
     * sql驱动程序类型
     */
    private String jdbcDriver;

    /***
     *sql连接地址
     */
    private String jdbcUrl;

    /***
     * sql用户名
     */
    private String jdbcUsername;

    /***
     *sql密码
     */
    private String jdbcPassword;


    private String schemaPattern = null;

    private String[] tableNamePatterns = { "ff_%" };

    private String[] types = { "TABLE" };

    /***
     * 连接信息
     */
    private Properties connectionPros;

    /***
     *
     */
    private String[] excludes;

    /***
     * 不包含
     */
    private String[] includes;


    private String[] idCustoms;
    // 指定id
    private Map<String, String> idMap;
    // 需要排除的表
    private Map<String, String> inclusionMap;
    // 需要排除的表
    private Map<String, String> exclusionMap;

    private boolean saveBean = true;
    private boolean saveDto  = true;
    private boolean saveMapper  = true;
    private boolean saveMapperXml  = true;
    private boolean saveService  = true;
    private boolean saveServiceImpl  = true;

    private String saveBeanPath;
    private String saveDtoPath;
    private String saveMapperPath;
    private String saveMapperXmlPath;
    private String saveServicePath;
    private String saveServiceImplPath;
    private String saveViewPath;
    private String saveEnumPath;

    private String modelName;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getSchemaPattern() {
        return schemaPattern;
    }

    public void setSchemaPattern(String schemaPattern) {
        this.schemaPattern = schemaPattern;
    }

    public String[] getTableNamePatterns() {
        return tableNamePatterns;
    }

    public void setTableNamePatterns(String[] tableNamePatterns) {
        this.tableNamePatterns = tableNamePatterns;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public Properties getConnectionPros() {
        return connectionPros;
    }

    public void setConnectionPros(Properties connectionPros) {
        this.connectionPros = connectionPros;
    }

    public String[] getExcludes() {
        return excludes;
    }

    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }

    public String[] getIncludes() {
        return includes;
    }

    public void setIncludes(String[] includes) {
        this.includes = includes;
    }

    public String[] getIdCustoms() {
        return idCustoms;
    }

    public void setIdCustoms(String[] idCustoms) {
        this.idCustoms = idCustoms;
    }

    public Map<String, String> getIdMap() {
        return idMap;
    }

    public void setIdMap(Map<String, String> idMap) {
        this.idMap = idMap;
    }

    public Map<String, String> getInclusionMap() {
        return inclusionMap;
    }

    public void setInclusionMap(Map<String, String> inclusionMap) {
        this.inclusionMap = inclusionMap;
    }

    public Map<String, String> getExclusionMap() {
        return exclusionMap;
    }

    public void setExclusionMap(Map<String, String> exclusionMap) {
        this.exclusionMap = exclusionMap;
    }

    public boolean isSaveBean() {
        return saveBean;
    }

    public void setSaveBean(boolean saveBean) {
        this.saveBean = saveBean;
    }

    public boolean isSaveDto() {
        return saveDto;
    }

    public void setSaveDto(boolean saveDto) {
        this.saveDto = saveDto;
    }

    public boolean isSaveMapper() {
        return saveMapper;
    }

    public void setSaveMapper(boolean saveMapper) {
        this.saveMapper = saveMapper;
    }

    public boolean isSaveMapperXml() {
        return saveMapperXml;
    }

    public void setSaveMapperXml(boolean saveMapperXml) {
        this.saveMapperXml = saveMapperXml;
    }

    public boolean isSaveService() {
        return saveService;
    }

    public void setSaveService(boolean saveService) {
        this.saveService = saveService;
    }

    public boolean isSaveServiceImpl() {
        return saveServiceImpl;
    }

    public void setSaveServiceImpl(boolean saveServiceImpl) {
        this.saveServiceImpl = saveServiceImpl;
    }

    public String getSaveBeanPath() {
        return saveBeanPath;
    }

    public void setSaveBeanPath(String saveBeanPath) {
        this.saveBeanPath = saveBeanPath;
    }

    public String getSaveDtoPath() {
        return saveDtoPath;
    }

    public void setSaveDtoPath(String saveDtoPath) {
        this.saveDtoPath = saveDtoPath;
    }

    public String getSaveMapperPath() {
        return saveMapperPath;
    }

    public void setSaveMapperPath(String saveMapperPath) {
        this.saveMapperPath = saveMapperPath;
    }

    public String getSaveMapperXmlPath() {
        return saveMapperXmlPath;
    }

    public void setSaveMapperXmlPath(String saveMapperXmlPath) {
        this.saveMapperXmlPath = saveMapperXmlPath;
    }

    public String getSaveServicePath() {
        return saveServicePath;
    }

    public void setSaveServicePath(String saveServicePath) {
        this.saveServicePath = saveServicePath;
    }

    public String getSaveServiceImplPath() {
        return saveServiceImplPath;
    }

    public void setSaveServiceImplPath(String saveServiceImplPath) {
        this.saveServiceImplPath = saveServiceImplPath;
    }

    public String getSaveViewPath() {
        return saveViewPath;
    }

    public void setSaveViewPath(String saveViewPath) {
        this.saveViewPath = saveViewPath;
    }

    public String getSaveEnumPath() {
        return saveEnumPath;
    }

    public void setSaveEnumPath(String saveEnumPath) {
        this.saveEnumPath = saveEnumPath;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
