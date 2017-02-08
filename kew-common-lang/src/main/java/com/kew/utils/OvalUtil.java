package com.kew.utils;

import com.kew.check.CustomResourceBundleMessageResolver;
import com.kew.exception.ExceptionCode;
import com.kew.exception.OvalUNCheckedException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by qiudanping on 2017/2/8.
 */
public class OvalUtil {

    private static Logger logger = LoggerFactory.getLogger(OvalUtil.class);

    public static <T>T firstRealVal(T ...objects){
        for (Object object : objects) {
            if(object!=null&&!"".equals(object)){
                return (T)object;
            }
        }
        return null;
    }

    public static String enumValues(Class<?> menum){
        StringBuilder valstr = new StringBuilder();
        try {
            Object[] values;
            values = (Object[])menum.getMethod("values").invoke(menum);
            valstr.append("[");
            String pre = "";
            for (int i = 0; i < values.length; i++) {
                valstr.append(pre+values[i].getClass().getMethod("getCode").invoke(values[i]));
                pre = ",";
            }
            valstr.append("]");
        }catch (Exception e) {
            logger.error("枚举反射取值", e);
        }
        return valstr.toString();
    }

    public static void validate(Object bean){
        // 初始化
        Validator validator = new Validator(new AnnotationsConfigurer());
        Validator.setMessageResolver(new CustomResourceBundleMessageResolver("zh"));
        // 校验bean值是否合法
        List<ConstraintViolation> violations = validator.validate(bean);
        StringBuilder errormsg = new StringBuilder();
        errormsg.append("参数验证异常 : ");
        if (violations.size()>0){
            for (ConstraintViolation constraintViolation : violations) {
                errormsg.append(constraintViolation.getMessage().replaceAll(bean.getClass().getName()+".",""));
            }
            throw new OvalUNCheckedException(ExceptionCode.ILLEGAL_PARAMETER.getCode(),errormsg.toString());
        }
    }
}
