package com.example.dell.javabasedemo.annotation;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建日期：2019/4/8
 * 作者:baiyang
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@RequiresApi(api = Build.VERSION_CODES.N)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Roles.class)
public @interface Role {
    String value() default "";
}
