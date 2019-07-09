package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;
import com.example.dell.javabasedemo.javaBean.Person;
import com.example.dell.javabasedemo.runnable.AtomicIntegerArrayRunnable;
import com.example.dell.javabasedemo.runnable.AtomicIntegerRunnable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 创建日期：2019/6/17
 * 作者:baiyang
 * 并发包中的原子操作类(Atomic系列)
 * https://blog.csdn.net/javazejian/article/details/72772470
 */
public class AtomicActivity extends BaseActivity {
    private static final String TAG = "AtomicActivity";
    private Button btn_test;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Atomic";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_common;
    }

    @Override
    protected void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //test1();
                    test3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test2();
            }
        });
    }

    /**
     * AtomicInteger 练习
     */
    private void test1() throws InterruptedException {
        AtomicIntegerRunnable atomicIntegerRunnable = new AtomicIntegerRunnable();
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(atomicIntegerRunnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].join();
        }
        int value = atomicIntegerRunnable.getValue();
        Log.e(TAG, "test1 value:" + value);

    }

    /**
     * AtomicReference
     * 必须设置初始值 看源码可知 是要通过这个初始值 在实体中找到该
     * 变量的内存地址值
     */
    private void test2() {
        AtomicReference<Person> atomicReference = new AtomicReference<>();
        Person lufei = new Person("lufei", 99);
        atomicReference.set(lufei);

        Person namei = new Person("namei", 100);
        atomicReference.compareAndSet(lufei, namei);

        Person person = atomicReference.get();

        Log.e(TAG, "test2: person.getName():" + person.getName());

    }

    /**
     * AtomicIntegerArray
     * todo 多个atomic 同步测试
     */
    private void test3() throws InterruptedException {
        AtomicIntegerArrayRunnable atomicIntegerArrayRunnable = new AtomicIntegerArrayRunnable();
        Thread[] threadArrays = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadArrays[i] = new Thread(atomicIntegerArrayRunnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArrays[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threadArrays[i].join();
        }

        int value = atomicIntegerArrayRunnable.getValue();
        Log.e(TAG, "test3: value:" + value);

    }
}
