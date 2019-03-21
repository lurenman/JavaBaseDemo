package com.example.dell.javabasedemo.reflection;

import android.util.Log;

/**
 * 创建日期：2019/3/9
 * 作者:baiyang
 */
public class Student extends Person {
    private static final String TAG = "Student";
    public String desc;
    private int score = 100;

    //    public Student() {
//    }
    private void learn() {
        Log.e(TAG, "learn()方法被调用");
    }

    private void learn(int time, String subject) {
        Log.e(TAG, "learn(int time, String subject)方法被调用");
    }

    public int test() {
        Log.e(TAG, "test()方法被调用");
        return 100;
    }

    public String getDesc() {
        return desc;
    }

    public Student setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Student setScore(int score) {
        this.score = score;
        return this;
    }
}
