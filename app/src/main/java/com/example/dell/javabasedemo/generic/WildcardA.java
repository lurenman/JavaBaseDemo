package com.example.dell.javabasedemo.generic;

import android.util.Log;

/**
 * 创建日期：2019/3/20
 * 作者:baiyang
 */
public class WildcardA<T> {
    private static final String TAG = "wildcardA";
    private T type;

    public WildcardA(T type) {
        this.type = type;
    }

    public void foo(){
        String simpleName = type.getClass().getSimpleName();
        Log.e(TAG, "A-foo()"+simpleName+":"+type);
    }
}
