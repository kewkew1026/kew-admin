package com.kew.check;

import net.sf.oval.localization.message.MessageResolver;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by qiudanping on 2017/2/8.
 * 错误信息语言绑定
 */
public class CustomResourceBundleMessageResolver implements MessageResolver {

    private static Map<String,ResourceBundle> allMessageBundles = new LinkedHashMap<String, ResourceBundle>();

    private ResourceBundle currentResourceBundle = null;

    public CustomResourceBundleMessageResolver(String local){
        addMessageBundle(local);
    }

    /**
     * addMessageBundle 根据语言添加国际化资源文件
     * @param local
     * @return
     * @since  1.0.0
     */
    public void addMessageBundle(String local){
        if("cn".equalsIgnoreCase(local)){
            local = "zh";
        }
        if(!allMessageBundles.containsKey(local)){
            allMessageBundles.put(local,ResourceBundle.getBundle("i18n/CustomMessages",new Locale(local)));
        }
        currentResourceBundle = allMessageBundles.get(local);
    }

    /**
     * 返回国际化信息
     */
    public String getMessage(final String key){
        if (currentResourceBundle.getObject(key)!=null) {
            return currentResourceBundle.getString(key);
        }
        return null;
    }

    /**
     * 返回国际化信息
     */
    public String getMessage(final String key,String def){
        if (currentResourceBundle.getObject(key)!=null) {
            return currentResourceBundle.getString(key);
        }
        return def;
    }
}
