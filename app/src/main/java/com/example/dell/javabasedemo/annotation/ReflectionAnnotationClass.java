package com.example.dell.javabasedemo.annotation;

/**
 * 创建日期：2019/4/8
 * 作者:baiyang
 */
public class ReflectionAnnotationClass {
    @AnnotationInfo(name = "苏芒")
    private String name;
    @AnnotationInfo(age = 29)
    private int age;

    public String getName() {
        return name;
    }

    public ReflectionAnnotationClass setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public ReflectionAnnotationClass setAge(int age) {
        this.age = age;
        return this;
    }

    @AnnotationMethodInfo(x = 10, y = 20)
    private String foo(int x, int y) {
        int i = x + y;
        String toString = Integer.toString(i);
        return toString;
    }

    @AnnotationMethodInfo(x = 10, y = 20, NEST = @AnnotationNest(isSpecial = true))
    private String foo1(int x, int y) {
        int i = x + y;
        String toString = Integer.toString(i);
        return toString;
    }
}
