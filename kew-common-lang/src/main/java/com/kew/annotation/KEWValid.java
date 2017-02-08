package com.kew.annotation;

import com.kew.check.Constants;
import com.kew.check.KEWValidCheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by qiudanping on 2017/2/8.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@net.sf.oval.configuration.annotation.Constraint(checkWith = KEWValidCheck.class)
public @interface KEWValid {
    int max() default Integer.MAX_VALUE;
    int min() default 0;
    String regModel() default Constants.XSS;
    boolean required() default false;
    String message() default "com.dsa.message.error.model";
}
