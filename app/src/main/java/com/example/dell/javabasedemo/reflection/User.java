package com.example.dell.javabasedemo.reflection;

/**
 * 创建日期：2019/3/9
 * 作者:baiyang
 */
public class User {
    private int age;
    private String name;

    public User() {
       // super();
    }

    public User(String name) {
        super();
        this.name = name;
    }

    /**
     * 私有构造
     *
     * @param age
     * @param name
     */
    private User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
