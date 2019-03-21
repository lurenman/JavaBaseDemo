package com.example.dell.javabasedemo.generic;

/**
 * 创建日期：2019/3/20
 * 作者:baiyang
 * 接口T类型是类传过来的，如果指定接口类型就不用指定类传过来的类型
 */
public class InterfaceClass<T> implements Generator<T> {
    private T type;

    public InterfaceClass(T type) {
        this.type = type;
    }

    @Override
    public T next() {
        return type;
    }
}
