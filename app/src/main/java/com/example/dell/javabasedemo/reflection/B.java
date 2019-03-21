package com.example.dell.javabasedemo.reflection;

import android.util.Log;

/**
 * 创建日期：2019/3/7
 * 作者:baiyang
 */
public class B {
    private static final String TAG = "B";

    static {
        Log.e(TAG, "static initializer: B");
    }
}
