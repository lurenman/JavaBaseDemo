package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;
import com.example.dell.javabasedemo.generic.Generator;
import com.example.dell.javabasedemo.generic.GeneratorMethod;
import com.example.dell.javabasedemo.generic.GenericClass;
import com.example.dell.javabasedemo.generic.InterfaceClass;
import com.example.dell.javabasedemo.generic.WildcardA;

import java.util.ArrayList;

/**
 * 创建日期：2019/3/20
 * 作者:baiyang
 * 参考 https://www.cnblogs.com/coprince/p/8603492.html
 */
public class GenericActivity extends BaseActivity {
    private static final String TAG = "GenericActivity";
    private Button btn_characteristics;
    private Button btn_class;
    private Button btn_interface;
    private Button btn_wildcard;
    private Button btn_method;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "泛型";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_generic;
    }

    @Override
    protected void initView() {
        btn_characteristics = (Button) findViewById(R.id.btn_characteristics);
        btn_class = (Button) findViewById(R.id.btn_class);
        btn_interface = (Button) findViewById(R.id.btn_interface);
        btn_wildcard = (Button) findViewById(R.id.btn_wildcard);
        btn_method = (Button) findViewById(R.id.btn_method);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        btn_characteristics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                characteristicsMethod();
            }
        });
        btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classMethod();
            }
        });
        btn_interface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceMethod();
            }
        });
        btn_wildcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WildcardA<String> stringWildcardA = new WildcardA<>("haha");
                WildcardA<Integer> integerWildcardA = new WildcardA<>(123);
                wildcardMethod(stringWildcardA);
                wildcardMethod(integerWildcardA);
            }
        });
        btn_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodMethod();
            }
        });
    }

    /**
     * 通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，
     * 会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。
     * 对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     * 看过类加载的机制这也很好理解 ，class对象指向一个
     */
    private void characteristicsMethod() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Class<? extends ArrayList> stringArrayListClass = stringArrayList.getClass();
        Class<? extends ArrayList> integerArrayListClass = integerArrayList.getClass();
        if (stringArrayListClass.equals(integerArrayListClass)) {
            Log.e(TAG, "onClick: " + "类型相同");
        }
    }

    private void classMethod() {
        GenericClass<String> stringGenericClass = new GenericClass<>("String");
        GenericClass<Integer> integerGenericClass = new GenericClass<>(123);
        Log.e(TAG, "stringGenericClass key: " + stringGenericClass.getKey());
        Log.e(TAG, "integerGenericClass key: " + integerGenericClass.getKey());
        //不指定泛型实参，传入的参数就随意
        GenericClass integerGenericClass1 = new GenericClass<>(11111);
        Log.e(TAG, "integerGenericClass1 key: " + integerGenericClass1.getKey());
    }

    /**
     * 泛型接口
     */
    private void interfaceMethod() {
        InterfaceClass<String> stringInterfaceClass = new InterfaceClass<>("娜美");
        String nextStr = stringInterfaceClass.next();
        Log.e(TAG, "nextStr:" + nextStr);
        InterfaceClass<Integer> integerInterfaceClass = new InterfaceClass<>(124);
        Integer nextInteger = integerInterfaceClass.next();
        Log.e(TAG, "nextInteger:" + nextInteger);
    }

    /**
     * 通配符练习
     * 就是不同的泛型实参传过来
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。重要说三遍！此处’？’是类型实参，
     * 而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，
     * 可以把？看成所有类型的父类。是一种真实的类型。
     * 可以解决当具体类型不确定的时候，这个通配符就是 ?  ；当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ?
     * 通配符来表未知类型。
     */
    private void wildcardMethod(WildcardA<?> wildcardA) {
        wildcardA.foo();
    }

    /**
     * 泛型方法
     */
    private void methodMethod() {
        GeneratorMethod<String> stringGeneratorMethod = new GeneratorMethod<>("lufei");
        stringGeneratorMethod.foo(123);
        stringGeneratorMethod.foo1("haha");
        stringGeneratorMethod.foo2("aaaa", "000");
        stringGeneratorMethod.foo3(new GenericClass<String>("foo3"));
        stringGeneratorMethod.foo4(new Generator<Integer>() {
            @Override
            public Integer next() {
                return 66666;
            }
        });
        stringGeneratorMethod.foo5(new GenericClass<>(7777), "xiaomei");
        stringGeneratorMethod.foo6("招摇", 20);

        GeneratorMethod.foo7("历尘澜");
        GeneratorMethod.foo8(new GenericClass<Integer>(999));
        GeneratorMethod.foo9(new Generator<Integer>() {
            @Override
            public Integer next() {
                return 4444;
            }
        });
    }
    //泛型数组略
}
