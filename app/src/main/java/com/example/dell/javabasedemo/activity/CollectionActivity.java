package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

/**
 * 创建日期：2018/8/30
 * 作者:baiyang
 * 参考https://blog.csdn.net/itlwc/article/details/10148321
 * https://www.cnblogs.com/taiwan/p/6954135.html
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "CollectionActivity";

    private Button bt_click;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Collection";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initView() {
        bt_click = (Button) findViewById(R.id.bt_click);
        bt_click.setOnClickListener(this);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {

    }


    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_click:
                //click_list();
                //click_ArrayList();
                //click_Vector();
                //click_Stack();
                //click_LinkedList();
                //click_TreeSet();
                click_Queue();
                break;
        }
    }

    /**
     * 只展示个别
     */
    private void click_list() {
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(1);

        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            Log.e(TAG, "click_list: " + str);
        }
    }

    private void click_ArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Log.e(TAG, "click_ArrayList: " + next);
        }
        for (Iterator<String> iterator1 = list.iterator(); iterator1.hasNext(); ) {
            String next = iterator1.next();
            Log.e(TAG, "click_ArrayList: " + next);
        }
    }

    private void click_Vector() {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        for (int i = 0; i < vector.size(); i++) {
            String s = vector.get(i);
            Log.e(TAG, "click_Vector: " + s);
        }
        Log.e(TAG, "------------------ ");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Log.e(TAG, "click_Vector: " + next);
        }
        Log.e(TAG, "------------------ ");
        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            String nextElement = elements.nextElement();
            Log.e(TAG, "click_Vector: " + nextElement);
        }
    }

    /**
     * Vector的子类
     * 可参考源码
     */
    private void click_Stack() {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        Enumeration<String> elements = stack.elements();
        while (elements.hasMoreElements()) {
            String s = elements.nextElement();
            Log.e(TAG, "click_Stack: " + s);
        }
        Log.e(TAG, "------------------ ");
        //返回栈顶元素
        String peek = stack.peek();
        Log.e(TAG, "click_Stack: " + peek);
        Log.e(TAG, "------------------ ");
        while (stack.size() > 0) {
            //出栈看源码可知先peek拿到栈顶元素在移除掉
            String pop = stack.pop();
            Log.e(TAG, "click_Stack: " + pop);
        }

    }

    private void click_LinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Log.e(TAG, "click_LinkedList: " + next);
        }
        Log.e(TAG, "------------------ ");
        // 的到链表的迭代器,位置指向link.size()结尾
        ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            Log.e(TAG, "click_LinkedList: " + previous);
        }
    }

    private void click_TreeSet() {
//        TreeSet<Person> treeSet = new TreeSet<>();
//        treeSet.add(new Person("lurenman", 80));
//        treeSet.add(new Person("lufei", 90));
//        treeSet.add(new Person("namei", 70));
//        Iterator<Person> iterator = treeSet.iterator();
//        while (iterator.hasNext()) {
//            Person person = iterator.next();
//            int score = person.getScore();
//            Log.e(TAG, "click_TreeSet:" + score);
//        }
    }

    /**
     * 这个PriorityQueue有个排序的 还有一个11容量
     */
    private void click_Queue() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3);
        for (int i = 0; i < 12; i++) {
            //priorityQueue.add(i + "");
            priorityQueue.offer(i + "");
        }
        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Log.e(TAG, "click_Queue: " + next);
        }
        //看源码可知道返回第一个元素
        String element = priorityQueue.element();
        Log.e(TAG, "element: " + element);
        String peek = priorityQueue.peek();
        Log.e(TAG, "peek: " + peek);
    }
}
