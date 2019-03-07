package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;

/**
 * 创建日期：2018/8/10
 * 作者:baiyang
 * 参考https://www.cnblogs.com/bluestorm/p/5795461.html
 */
public class BitOperationActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "BitOperationActivity";
    private Button bt_click;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "BitOperation";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_bitoperation;
    }

    @Override
    protected void initView() {
        bt_click = (Button) findViewById(R.id.bt_click);
    }
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        bt_click.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    //a 的值是129，转换成二进制就是10000001，而b 的值是128，转换成二进制就是10000000
    //也可以理解true 为1 false为0
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_click:
                click_1();
                click_2();
                click_3();
                click_4();
                click_5();
                break;
        }
    }

    /**
     * 运算符用符号“&”
     */
    private void click_1() {
        int a = 129;
        int b = 128;
        Log.e(TAG, "a & b: " + (a & b));
    }

    /**
     * 或运算符
     */
    private void click_2() {
        int a = 129;
        int b = 128;
        Log.e(TAG, "a | b: " + (a | b));
    }

    /**
     * 非运算符
     * 非运算符用符号“~”表示，其运算规律如下：
     * <p>
     * 如果位为0，结果是1，如果位为1，结果是0
     */
    private void click_3() {
        int a = 2;
        Log.e(TAG, "a 非的结果是：" + (~a));
    }

    /**
     * 异或运算符
     * 异或运算符是用符号“^”表示的，其运算规律是：
     * 两个操作数的位中，相同则结果为0，不同则结果为1。
     */
    private void click_4() {
        int a = 15;
        int b = 2;
        Log.e(TAG, "a 与 b 异或的结果是：" + (a ^ b));
    }

    /**
     * 注：x<<y 相当于 x*2y ；x>>y相当于x/2y
     * 从计算速度上讲，移位运算要比算术运算快。
     * 如果x是负数，那么x>>>3没有什么算术意义，只有逻辑意义
     * 注意：y为幂数
     */
    private void click_5() {
        int x = 2;
        int y = 3;
        //2*8=16
        Log.e(TAG, "x<<y: " + (x << y));
        //2/8
        Log.e(TAG, "x>>y: " + (x >> y));
        //"无符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。采用0扩展机制，也就是说，无论值的正负，都在高位补0.
        Log.e(TAG, "x>>>y: " + (x >>> y));
    }
}
