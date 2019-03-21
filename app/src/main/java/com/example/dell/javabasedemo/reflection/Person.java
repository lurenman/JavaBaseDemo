package com.example.dell.javabasedemo.reflection;

import android.util.Log;

/**
 * 创建日期：2019/3/9
 * 作者:baiyang
 */
public class Person {
    private static final String TAG = "Person";
    public int age;
    public String name;

    /**
     * 繁衍
     */
    public void multiply() {
        Log.e(TAG, "multiply()方法被调用");
    }

    /**
     * 攻击 这种私有方法 在子类反射是获取不到的
     */
    private void attack() {

    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
