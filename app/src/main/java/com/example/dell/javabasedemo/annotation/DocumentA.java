package com.example.dell.javabasedemo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建日期：2019/4/8
 * 作者:baiyang
 * @Documented 被修饰的注解会生成到javadoc中
 * @Inherited 可以让注解被继承，但这并不是真的继承，只是通过使用@Inherited，
 * 可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentA {
}
