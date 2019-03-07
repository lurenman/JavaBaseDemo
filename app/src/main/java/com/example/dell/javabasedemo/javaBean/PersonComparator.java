package com.example.dell.javabasedemo.javaBean;

/**
 * 创建日期：2018/9/27
 * 作者:baiyang
 */
public class PersonComparator {
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
        return p1.score - p2.score;
    }
}
