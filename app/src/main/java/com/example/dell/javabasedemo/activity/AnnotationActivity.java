package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;
import com.example.dell.javabasedemo.annotation.AnnotationInfo;
import com.example.dell.javabasedemo.annotation.AnnotationMethodInfo;
import com.example.dell.javabasedemo.annotation.AnnotationNest;
import com.example.dell.javabasedemo.annotation.B;
import com.example.dell.javabasedemo.annotation.D;
import com.example.dell.javabasedemo.annotation.ReflectionAnnotationClass;
import com.example.dell.javabasedemo.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 创建日期：2018/12/7
 * 作者:baiyang
 * 参考https://blog.csdn.net/javazejian/article/details/71860633
 * 定义注解的时候最好都有默认值省了判断null
 */
public class AnnotationActivity extends BaseActivity {
    private static final String TAG = "AnnotationActivity";
    private Button btn_test;
    private Button btn_Inherited;
    private Button btn_reflection;
    private Button btn_repeatable;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Annotation";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_annotation;
    }

    @Override
    protected void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_Inherited = (Button) findViewById(R.id.btn_Inherited);
        btn_reflection = (Button) findViewById(R.id.btn_reflection);
        btn_repeatable = (Button) findViewById(R.id.btn_repeatable);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_Inherited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inheritedMethod();
            }
        });
        btn_reflection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    reflectionFieldMethod();
                    reflectionAnnotationMethod();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn_repeatable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 后续java8练习
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Test(name = "test", age = 20)
    // @Test("value")
    private void test() {

    }

    /**
     * getAnnotations()
     * 返回此元素上存在的所有注解，包括从父类继承的
     * 说明只有Inherited注解的才会被继承，平常getAnnotations()
     * 这种只能获取当前类的 注解 信息
     * 看源码也能看到
     */
    private void inheritedMethod() {
        B b = new B();
        Annotation[] annotations = b.getClass().getAnnotations();
        String toString = Arrays.toString(annotations);
        D d = new D();
        Annotation[] annotations1 = d.getClass().getAnnotations();
        String toString1 = Arrays.toString(annotations1);
        Log.e(TAG, "b: " + toString + "\n" + "d: " + toString1);
    }

    /**
     * 结合反射的一个小例子
     * 演示通过注解信息改变当前类field 字段信息
     */

    private void reflectionFieldMethod() throws Exception {
        ReflectionAnnotationClass reflectionAnnotationClass = new ReflectionAnnotationClass();
        Field nameField = reflectionAnnotationClass.getClass().getDeclaredField("name");
        Annotation[] nameFieldDeclaredAnnotations = nameField.getDeclaredAnnotations();
        for (Annotation annotation : nameFieldDeclaredAnnotations) {
            if (annotation instanceof AnnotationInfo) {
                String name = ((AnnotationInfo) annotation).name();
                nameField.setAccessible(true);
                nameField.set(reflectionAnnotationClass, name);
            }
        }

        Field ageField = reflectionAnnotationClass.getClass().getDeclaredField("age");
        // 通过getDeclaredAnnotationsByType的方式获取指定注解类型@RequiresApi(api = Build.VERSION_CODES.N)
//        AnnotationInfo[] ageFieldDeclaredAnnotationsByType = ageField.getDeclaredAnnotationsByType(AnnotationInfo.class);
//        if (ageFieldDeclaredAnnotationsByType!=null&&ageFieldDeclaredAnnotationsByType.length>0){
//            AnnotationInfo annotationInfo = ageFieldDeclaredAnnotationsByType[0];
//            int age = annotationInfo.age();
//            ageField.setAccessible(true);
//            ageField.set(reflectionAnnotationClass,age);
//        }
        //第二种通过getAnnotation该元素如果存在指定类型的注解，则返回这些注解，否则返回 null。
        if (ageField.isAnnotationPresent(AnnotationInfo.class)) {
            AnnotationInfo annotation = ageField.getAnnotation(AnnotationInfo.class);
            int age = annotation.age();
            ageField.setAccessible(true);
            ageField.set(reflectionAnnotationClass, age);
        }
        Log.e(TAG, "reflectionAnnotationClass.getName(): " + reflectionAnnotationClass.getName());
        Log.e(TAG, "reflectionAnnotationClass.getAge(): " + reflectionAnnotationClass.getAge());
    }

    /**
     * 演示拿到方法上的注解，还有嵌套注解搞一些动作
     */
    private void reflectionAnnotationMethod() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.annotation.ReflectionAnnotationClass");
        ReflectionAnnotationClass reflectionAnnotationClass = (ReflectionAnnotationClass) aClass.newInstance();
        Method fooMethod = aClass.getDeclaredMethod("foo", int.class, int.class);
        Method foo1Method = aClass.getDeclaredMethod("foo1", int.class, int.class);
        //开始获取foo()方法注解上的值
        AnnotationMethodInfo fooMethodAnnotation = fooMethod.getAnnotation(AnnotationMethodInfo.class);
        if (fooMethodAnnotation != null) {
            AnnotationNest nest = fooMethodAnnotation.NEST();
            int x = fooMethodAnnotation.x();
            int y = fooMethodAnnotation.y();
            fooMethod.setAccessible(true);
            String value;
            if (nest.isSpecial()) {
                value = (String) fooMethod.invoke(reflectionAnnotationClass, 100, 100);
            } else {
                value = (String) fooMethod.invoke(reflectionAnnotationClass, x, y);
            }
            Log.e(TAG, "foo(): " + value);
        }

        AnnotationMethodInfo foo1MethodAnnotation = foo1Method.getAnnotation(AnnotationMethodInfo.class);
        if (foo1MethodAnnotation != null) {
            AnnotationNest nest = foo1MethodAnnotation.NEST();
            int x = foo1MethodAnnotation.x();
            int y = foo1MethodAnnotation.y();
            foo1Method.setAccessible(true);
            String value;
            if (nest.isSpecial()) {
                value = (String) foo1Method.invoke(reflectionAnnotationClass, 100, 100);
            } else {
                value = (String) foo1Method.invoke(reflectionAnnotationClass, x, y);
            }
            Log.e(TAG, "foo1(): " + value);
        }
    }
}
