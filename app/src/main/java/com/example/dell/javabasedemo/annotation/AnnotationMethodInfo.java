package com.example.dell.javabasedemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建日期：2019/4/8
 * 作者:baiyang
 * default @AnnotationNest
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationMethodInfo {
    int x() default -1;
    int y() default -1;
    AnnotationNest NEST() default @AnnotationNest;
}
