package com.kew.boss.enums;

/**
 * Created by qiudanping on 2017/5/31.
 */
public enum ResultCodeEnum {

    SUCCESS("00001","",null),
    FAILURE("00002","失败",null),
    ILLEGAL_ARGUMENTS("00002","参数异常",null),


    MENUE_CODE_EXIST("00010","菜单号不能重复" ,null );


    private Enum parent;

    private String code;

    private String description;

    public Enum getParent() {
        return parent;
    }

    public void setParent(Enum parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    ResultCodeEnum(String code, String description,Enum parent) {
        this.parent = parent;
        this.code = code;
        this.description = description;
    }
}
