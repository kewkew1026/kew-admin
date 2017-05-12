package com.kew.boss.controller;

import com.kew.boss.service.MenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiudanping on 2017/5/9.
 */
public class BaseController {

    Logger logger= LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected MenueService menueService = null;

    /**
     * 日期类型转换器
     * @param dataBinder 数据Binder
     */
    @InitBinder
    public void initDateBinder(WebDataBinder dataBinder) {
        //日期转换
        dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    if(value != null && !value.isEmpty()) {
                        setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                    } else {
                        setValue(null);
                    }
                } catch (java.text.ParseException e) {
                    logger.error("【解析时间出错】",e);
                }
            }

            public String getAsText() {
                if(getValue() != null) {
                    return new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());
                } else {
                    return null;
                }
            }
        });
        //字符串去空格
        dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            public void setAsText(String value) {
                if(value != null) {
                    setValue(value.trim());
                } else {
                    setValue(null);
                }
            }
            public String getAsText() {
                return (String)getValue();
            }
        });

    }
}
