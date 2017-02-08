package com.kew.exception;

/**
 * Created by qiudanping on 2017/2/8.
 */
public enum ExceptionCode {

    //正常
    NO_EXCEPTON("0000","正常","正常"),
    //系统异常 runtime exception
    UNKNOW_EXCEPTON("9999","未知异常","系统维护中，请稍后再试。"),
    //参数验证错误DSAVerifyParameException
    ILLEGAL_PARAMETER("1000", "参数异常","参数异常"),
    ;



    private ExceptionCode(String code, String desin, String desout) {
        this.code = code;
        this.desin = desin;
        this.desout = desout;
    }

    private String code;
    private String desin;
    private String desout;

    public String getCode() {
        return code;
    }
    public String getDesin() {
        return desin;
    }
    public String getDesout() {
        return desout;
    }

    public static ExceptionCode getByCode(String code) {
        if(code!=null&&!"".equals(code.trim())){
            for (ExceptionCode mnum : values()) {
                if (mnum.getCode().equals(code)) {
                    return mnum;
                }
            }
        }
        return null;
    }

    public static String getInMsg(String code) {
        if(code!=null&&!"".equals(code.trim())){
            for (ExceptionCode mnum : values()) {
                if (mnum.getCode().equals(code)) {
                    return mnum.getDesin();
                }
            }
        }
        return null;
    }

    public static String getOutMsg(String code) {
        if(code!=null&&!"".equals(code.trim())){
            for (ExceptionCode mnum : values()) {
                if (mnum.getCode().equals(code)) {
                    return mnum.getDesout();
                }
            }
        }
        return null;
    }
}
