package com.example.dell.javabasedemo.generic;

/**
 * 创建日期：2019/4/4
 * 作者:baiyang
 */
public class GenericClass1<T> extends GenericClass<T> {
    private String name;

    public GenericClass1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GenericClass1 setName(String name) {
        this.name = name;
        return this;
    }
}
