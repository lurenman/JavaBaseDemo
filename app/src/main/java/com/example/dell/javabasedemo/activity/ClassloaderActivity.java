package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.javabasedemo.R;
import com.example.dell.javabasedemo.classloader.FileClassLoader;
import com.example.dell.javabasedemo.util.AssetsUtils;

/**
 * 创建日期：2019/6/1
 * 作者:baiyang
 * 參考
 * https://blog.csdn.net/javazejian/article/details/73413292
 * https://blog.csdn.net/briblue/article/details/54973413
 *
 */
public class ClassloaderActivity extends BaseActivity {
    private static final String TAG = "ClassloaderActivity";
    private Button btn_test;
    private Button btn_copy;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Classloader";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_classloader;
    }

    @Override
    protected void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_copy = (Button) findViewById(R.id.btn_copy);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = AssetsUtils.copyFilesFassets(mContext, "class/TestLoaderClass.class", mContext.getExternalCacheDir().getAbsolutePath() + "/" + "TestLoaderClass.class");
                if (b){
                    Toast.makeText(mContext, "拷贝成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1();
            }
        });
    }

    /**
     * 加载指定路径下文件的class
     * todo 继续验证
     */
    private void test1() {
        String rootDir =  mContext.getExternalCacheDir().getAbsolutePath();
        //创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1 = loader.loadClass("com.example.dell.javabasedemo.classloader.TestLoaderClass");
            Log.e(TAG, "test1: " + object1.newInstance().toString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "e.getMessage(): " + e.getMessage());
        }


    }
}
