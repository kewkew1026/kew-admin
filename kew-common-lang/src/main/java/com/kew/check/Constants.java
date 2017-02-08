package com.kew.check;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiudanping on 2017/2/8.
 */
public class Constants {

    //非空
    final public static String NOT_EMPTY   = "notEmpty";
    //邮件
    final public static String EMAIL       = "email";
    //密码不能少于8位
    final public static String PASS        = "pass";
    //邮政编码
    final public static String ZIP_CODE    = "zipCode";
    //手机号码
    final public static String MOBILE      = "mobile";
    //手机号码
    final public static String MOBILE_CN  = "mobile_cn";
    //电话号码
    final public static String PHONE       = "phone";
    //网址
    final public static String URL         = "url";
    //是否是主键
    final public static String AMOUNT      = "amount";
    final public static String AMOUNT_WITH_DECIMAL = "amountWithDecimal";
    //地址　100字符以内
    final public static String PUTRESS     = "putress";
    //城市　50字符以内
    final public static String CITY        = "city";
    //时间如  201312125959
    final public static String DATETIME    = "datatime";
    //IP地址
    final public static String IP          = "ip";
    //NUMBER地址
    final public static String NUMBER      = "number";
    //XSS攻击
    final public static String XSS         = "xss";

    @SuppressWarnings("serial")
    public static final Map<String,String> MODEL_REG = new HashMap<String,String>(){{
        put(NOT_EMPTY,"^\\S.*$");
        put(EMAIL,"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
        put(PASS,"^\\S{8,}$");
        put(ZIP_CODE,"^(\\S{0,10})?$");
        put(MOBILE,"^(\\d{0,20})?$");
        put(MOBILE_CN,"^((13[0-9])|(15[0-9])|(17[0-9])|(18[0,5-9]))\\d{8}$");
        put(PHONE,"^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$");
        put(URL,"^http[s]?:\\/\\/((localhost.*)|(127.0.0.1.*)|(([\\w-]+\\.)+[\\w-]+([\\w-.(:(\\d){1,5})?/?%&=]*)?$))");
        put(AMOUNT,"^[0-9]{0,17}$");
        put(AMOUNT_WITH_DECIMAL,"(^[0-9]{0,17}$)|(^[1-9]\\d*\\.\\d{1,4}$)|(0\\.\\d{1,4}$)");
        put(IP,"([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
        put(DATETIME,"^(?:(?!0000)[0-9]{4}(?:(?:0[1-9]|1[0-2])(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])(?:29|30)|(?:0[13578]|1[02])31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9]$");
        put(NUMBER,"^\\d$");
        put(XSS,".*[%<>\\{\\}\"'#]+.*");
    }};

    @SuppressWarnings("serial")
    public static final Map<String,String> MODEL_MSG_KEY = new HashMap<String,String>(){{
        put(NOT_EMPTY,"com.dsa.message.error.model."+NOT_EMPTY);
        put(EMAIL,"com.dsa.message.error.model."+EMAIL);
        put(ZIP_CODE,"com.dsa.message.error.model."+ZIP_CODE);
        put(MOBILE,"com.dsa.message.error.model."+MOBILE);
        put(PHONE,"com.dsa.message.error.model."+PHONE);
        put(URL,"com.dsa.message.error.model."+URL);
        put(AMOUNT,"com.dsa.message.error.model."+AMOUNT);
        put(NUMBER,"com.dsa.message.error.model."+NUMBER);
        put(XSS,"com.dsa.message.error.model."+XSS);
    }};

    public static String loadRegBy(String model){
        if(MODEL_REG.containsKey(model)){
            return MODEL_REG.get(model);
        }
        return null;
    }

    public static String loadMsgKeyBy(String model){
        if(MODEL_MSG_KEY.containsKey(model)){
            return MODEL_MSG_KEY.get(model);
        }
        return null;
    }
}
