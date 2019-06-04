package com.example.dell.javabasedemo;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

/**
 * 创建日期：2019/4/16
 * 作者:baiyang
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this, "5cb5bbc13fc19512490013f7", "by", UMConfigure.DEVICE_TYPE_PHONE, null);
        UMConfigure.setLogEnabled(true);
    }
}
