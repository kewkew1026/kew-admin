package com.kew.${c.groupId}.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
* [文件名称]<br>
* BaseController <br>
* <br>
* [文件描述]<br>
* 内容摘要.<br>
* 基础Controller 包含类型转换器
* <br>
* @version 0.1
*/
public class BaseController {

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
e.printStackTrace();
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