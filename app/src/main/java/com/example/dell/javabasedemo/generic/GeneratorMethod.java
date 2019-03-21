package com.example.dell.javabasedemo.generic;

import android.util.Log;

/**
 * 创建日期：2019/3/20
 * 作者:baiyang
 */
public class GeneratorMethod<T> {
    private static final String TAG = "GeneratorMethod";
    private T type;

    public GeneratorMethod(T type) {
        this.type = type;
    }

    /**
     * 这是指定类型的普通方法
     *
     * @return
     */
    public T getType() {
        return type;
    }

    /**
     * 这才是泛型方法
     *
     * @param e
     * @param <E>
     */
    public <E> void foo(E e) {
        Log.e(TAG, "foo: " + e.getClass().getSimpleName() + ":" + e);
    }

    //这个T是全新的类型
    public <T> void foo1(T t) {
        Log.e(TAG, "foo1: " + t.getClass().getSimpleName() + ":" + t);
    }

    //返现没可以指定多个形参，可以理解为就是搞个声明
    public <T, E> void foo2(T t, E e) {
        Log.e(TAG, "foo2: " + t.getClass().getSimpleName() + ":" + t);
    }

    public <T> void foo3(GenericClass<T> genericClass) {
        T key = genericClass.getKey();
        Log.e(TAG, "foo3: " + key.getClass().getSimpleName() + ":" + key);
    }

    //接口
    public <T> void foo4(Generator<T> generator) {
        T next = generator.next();
        Log.e(TAG, "foo4: " + next.getClass().getSimpleName() + ":" + next);
    }

    public <T> void foo5(GenericClass<?> genericClass, T t) {
        Object key = genericClass.getKey();
//        if (key instanceof String){
//            继承的 子类 true
//        }
        if (key.getClass().equals(String.class)) {//纯属比较类
            Log.e(TAG, "foo5: " + "是String类型");
        }
        Log.e(TAG, "foo5: " + key.getClass().getSimpleName() + ":" + key);
        Log.e(TAG, "foo5: " + t.getClass().getSimpleName() + ":" + t);
    }

    /**
     * 泛型可变参数
     *
     * @param <T>
     */
    public <T> void foo6(T... args) {
        for (T t : args) {
            Log.e(TAG, "foo6: " + t.getClass().getSimpleName() + ":" + t);
        }
    }

    /**
     * 静态方法与泛型
     * 静态方法引用不了类上的泛型很好理解
     *
     * @param <T>
     */
    public static <T> void foo7(T t) {
        Log.e(TAG, "foo7: " + t.getClass().getSimpleName() + ":" + t);
    }

    /**
     * //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
     *
     * @param genericClass
     * @param <T>
     */
    public static <T extends Number> void foo8(GenericClass<T> genericClass) {
        T key = genericClass.getKey();
        Log.e(TAG, "foo7: " + key.getClass().getSimpleName() + ":" + key);
    }

    /**
     * 泛型下边界
     * @param generator
     */
    public static void foo9(Generator<? super Integer> generator) {
        Object next = generator.next();
        String simpleName = next.getClass().getSimpleName();
        Log.e(TAG, "foo9: " + simpleName + ":" + next);
    }
}
