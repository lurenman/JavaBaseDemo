package com.example.dell.javabasedemo.javaBean;

import java.util.Comparator;

/**
 * 创建日期：2018/9/27
 * 作者:baiyang
 */
public class Person implements Comparator {
    String name;
    int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Person setScore(int score) {
        this.score = score;
        return this;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return p1.score - p2.score;
    }
}






