package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.javabasedemo.R;

import java.lang.reflect.Field;

/**
 * 创建日期：2019/6/17
 * 作者:baiyang
 * -无锁CAS与Unsafe类
 * 参考：https://blog.csdn.net/javazejian/article/details/72772470
 */
public class CASActivity extends BaseActivity {

    private Button btn_test;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "无锁CAS与Unsafe类";
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
                    test1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void test1() throws Exception {

//        Class<?> aClass = Class.forName("sun.misc.Unsafe");
//
//        // 通过反射得到theUnsafe对应的Field对象
//        Field field = aClass.getDeclaredField("theUnsafe");
//        // 设置该Field为可访问
//        field.setAccessible(true);
//        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
//        Object unsafe = field.get(null);
//        aClass.getDeclaredMethod("")
        Toast.makeText(mContext, "请看博客", Toast.LENGTH_SHORT).show();

    }
}
