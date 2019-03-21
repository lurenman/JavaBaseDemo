package com.example.dell.javabasedemo.reflection;

import android.util.Log;

/**
 * 创建日期：2019/3/7
 * 作者:baiyang
 */
public class A {
    //编译期静态常量 不会引起类的初始化
    public static final String TAG = "A";
    //静态成员变量 调用会引起类的初始化
    public static int age=19;
    static {
        Log.e(TAG, "static initializer: A");
    }
}
