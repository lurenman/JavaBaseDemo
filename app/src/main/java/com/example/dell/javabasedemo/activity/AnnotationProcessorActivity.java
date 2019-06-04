package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;

/**
 * 创建日期：2019/5/21
 * 作者:baiyang
 * 参考https://blog.csdn.net/qq_20521573/article/details/82321755
 * https://blog.csdn.net/u013045971/article/details/53509237
 */
public class AnnotationProcessorActivity extends BaseActivity {

    private Button btn_test;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "注解处理器";
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
                test1();
            }
        });
    }

    private void test1() {

    }
}
