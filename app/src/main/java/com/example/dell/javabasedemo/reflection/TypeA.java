package com.example.dell.javabasedemo.reflection;

/**
 * 创建日期：2019/3/8
 * 作者:baiyang
 */
public class TypeA {
    protected String name="TypeA.class";
    protected int age;

    public String getName() {
        return name;
    }

    public TypeA setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TypeA setAge(int age) {
        this.age = age;
        return this;
    }
}
