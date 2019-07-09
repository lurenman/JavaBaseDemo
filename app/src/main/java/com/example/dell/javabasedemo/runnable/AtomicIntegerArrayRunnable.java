package com.example.dell.javabasedemo.runnable;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 创建日期：2019/6/18
 * 作者:baiyang
 * AtomicIntegerArray 原子数组的操作
 */
public class AtomicIntegerArrayRunnable implements Runnable {
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
    private int value;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            value = atomicIntegerArray.getAndIncrement(5);
        }
    }

    public int getValue() {
        return value;
    }
}
