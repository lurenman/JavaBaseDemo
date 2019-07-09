package com.example.dell.javabasedemo.runnable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建日期：2019/6/18
 * 作者:baiyang
 * AtomicInteger 原子操作
 */
public class AtomicIntegerRunnable implements Runnable {
    //默认初始化值为0
    private AtomicInteger atomicInteger = new AtomicInteger();
   // private AtomicInteger atomicInteger = new AtomicInteger(10);
    private int value;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            value = atomicInteger.incrementAndGet();
        }
    }

    /**
     * 获取无锁状态下的值
     * @return
     */
    public int getValue() {
        return value;
    }
}
