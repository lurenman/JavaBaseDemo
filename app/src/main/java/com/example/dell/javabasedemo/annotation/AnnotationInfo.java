package com.example.dell.javabasedemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建日期：2019/4/8
 * 作者:baiyang
 * 一个简单的人物信息
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationInfo {
    String name() default "";
    int age() default -1;
}
