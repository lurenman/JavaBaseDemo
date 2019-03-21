package com.example.dell.javabasedemo.generic;

/**
 * 创建日期：2019/3/20
 * 作者:baiyang
 * 泛型类
 */
public class GenericClass<T> {
    private T key;
    public GenericClass(){

    }
    public GenericClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public GenericClass<T> setKey(T key) {
        this.key = key;
        return this;
    }
}
