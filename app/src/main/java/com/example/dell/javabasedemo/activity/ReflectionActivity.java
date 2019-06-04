package com.example.dell.javabasedemo.activity;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.R;
import com.example.dell.javabasedemo.reflection.A;
import com.example.dell.javabasedemo.reflection.Student;
import com.example.dell.javabasedemo.reflection.TypeA;
import com.example.dell.javabasedemo.reflection.TypeB;
import com.example.dell.javabasedemo.reflection.User;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 * 创建日期：2018/12/6
 * 作者:baiyang
 * 参考
 * https://blog.csdn.net/javazejian/article/details/70768369
 */
public class ReflectionActivity extends BaseActivity {
    private static final String TAG = "ReflectionActivity";
    private Button btn_test;
    private Button btn_class_forname;
    private Button btn_type_conversion;
    private Button btn_constructor;
    private Button btn_field;
    private Button btn_method;
    private Button btn_array;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Reflection";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reflection;
    }

    @Override
    protected void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_class_forname = (Button) findViewById(R.id.btn_class_forname);
        btn_type_conversion = (Button) findViewById(R.id.btn_type_conversion);
        btn_constructor = (Button) findViewById(R.id.btn_constructor);
        btn_field = (Button) findViewById(R.id.btn_field);
        btn_method = (Button) findViewById(R.id.btn_method);
        btn_array = (Button) findViewById(R.id.btn_array);

    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initListenter() {
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new A();
                //String s = A.TAG;//引用静态变量没有初始化话
                try {
                    //className 引用类对象的引用所以初始化了
                    Class.forName("com.example.dell.javabasedemo.reflection.B");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_class_forname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classNameMethod();
            }
        });
        btn_type_conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeConversionMethod();
            }
        });
        btn_constructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    constructorMethod();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //fieldMethod();
                    fieldMethodUse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //reflectionMethod();
                    reflectionMethodUse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn_array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayMethod();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    /**
     * 三种获取class 对象的方式
     */
    private void classNameMethod() {
        try {
            Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.A");
            //https://blog.csdn.net/hustzw07/article/details/71108945 三者区别可参考
            Log.e(TAG, "classNameMethoda Class.getName(): " + aClass.getName());
            Log.e(TAG, "classNameMethod: aClass.getSimpleName(): " + aClass.getSimpleName());
            Log.e(TAG, "classNameMethod: aClass.getCanonicalName(): " + aClass.getCanonicalName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //通过实例对象获取Gum的Class对象
        A a = new A();
        Class<? extends A> aClass = a.getClass();
        Log.e(TAG, "classNameMethod a.getClass():" + aClass.getName());
        //在Java中存在另一种方式来生成Class对象的引用，它就是Class字面常量 这种不会初始化类
        Class<A> aClass1 = A.class;
        Log.e(TAG, "classNameMethod a.getClass():" + aClass1.getName());
        int age = A.age;
        Log.e(TAG, "A.age:" + age);
    }

    /**
     * 类型转换练习
     */
    private void typeConversionMethod() {
        cast2to(new TypeB());
    }

    /**
     * 类型转换
     *
     * @param obj
     */
    public void cast2to(Object obj) {
        if (obj instanceof TypeA) {
            TypeA a = (TypeA) obj;
            Log.e(TAG, "cast2to instanceof: " + a.getName());
        }
        if (TypeA.class.isInstance(obj)) {
            TypeA a = (TypeA) obj;
            Log.e(TAG, "cast2to isInstance: " + a.getName());
        }
    }

    private void constructorMethod() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.User");
        //实例化默认构造方法，User必须无参构造函数,否则将抛异常(无参数的构造函数必须有明写要不跑出下面异常)
        //java.lang.Class<com.example.dell.javabasedemo.reflection.User> has no zero argument constructor
        User user = (User) aClass.newInstance();
        user.setName("路飞");
        Log.e(TAG, "constructorMethod: " + user.getName());
        //获取带String参数的public构造函数
        Constructor<?> constructorString = aClass.getConstructor(String.class);
        User userString = (User) constructorString.newInstance("娜美");
        Log.e(TAG, "constructorMethod userString.getName():" + userString.getName());
        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor<?> declaredConstructorIntAndString = aClass.getDeclaredConstructor(int.class, String.class);
        //由于是private必须设置可访问
        declaredConstructorIntAndString.setAccessible(true);
        User userIntAndString = (User) declaredConstructorIntAndString.newInstance(20, "香吉士");
        Log.e(TAG, "constructorMethod userIntAndString.getName():" + userIntAndString.getName());

        //获取所有构造包含private
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Class<?>[] parameterTypes = declaredConstructors[i].getParameterTypes();
            Log.e(TAG, "constructorMethod 构造函数[" + i + "]： " + declaredConstructors[i].toString());
            for (int j = 0; j < parameterTypes.length; j++) {
                Class<?> parameterType = parameterTypes[j];
                Log.e(TAG, "constructorMethod  参数类型parameterTypes[" + j + "]: " + parameterType.getName());
            }
        }
        //还有下面几个方法略 注：getGenericParameterTypes 与 getParameterTypes 都是获取构成函数的参数类型，前者返回的是Type类型，后者返回的是Class类型
//        -----getDeclaringClass-----
//                构造方法的类:reflect.User
//                -----getGenericParameterTypes-----
//                参数名称tp:int
//        参数名称tp:class java.lang.String
//                -----getParameterTypes-----
//                参数名称:int
//        参数名称:java.lang.String
//                -----getName-----
//                getName:reflect.User
//                -----getoGenericString-----
//                getoGenericString():private reflect.User(int,java.lang.String)
//        ---------------------
    }

    /**
     * 注意declared 是指向本类声名的   declared这个理解了后面都好说
     *
     * @throws Exception
     */
    private void fieldMethod() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.Student");
        //这种是可以获取 父类的 但是只能public的
        Field fieldAge = aClass.getField("age");
        Log.e(TAG, "fieldMethod fieldAge.toString(): " + fieldAge.toString());
        //获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            Log.e(TAG, "fieldMethod f.getName(): " + f.getName());
            Log.e(TAG, "fieldMethod f.getDeclaringClass(): " + f.getDeclaringClass());//获取声明的类
        }
        Log.e(TAG, "-------------------------------------------------------");
        //获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
        Field fieldSocre = aClass.getDeclaredField("score");
        Class<?> type = fieldSocre.getType();
        Log.e(TAG, "fieldMethod fieldSocre.getType():" + type.toString());
        Type genericType = fieldSocre.getGenericType();
        Log.e(TAG, "fieldMethod fieldSocre.getGenericType():" + genericType.toString());
        Log.e(TAG, "fieldMethod: fieldSocre:" + fieldSocre);//private int com.example.dell.javabasedemo.reflection.Student.score
    }

    /**
     * field 实战
     * 需要特别注意的是被final关键字修饰的Field字段是安全的，在运行时可以接收任何修改，但最终其实际值是不会发生改变的。
     */
    private void fieldMethodUse() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.Student");
        Field scoreField = aClass.getDeclaredField("score");
        Student student = (Student) aClass.newInstance();
        // Student student1 = new Student();
        //设置可访问，score是private的
        scoreField.setAccessible(true);
        scoreField.set(student, 50);
        int score = scoreField.getInt(student);
        Log.e(TAG, "fieldMethodUse scoreField.getInt(student):" + score);
        Field tagField = aClass.getDeclaredField("TAG");
        tagField.setAccessible(true);
        String tagstr = (String) tagField.get(student);
        //String tagstr = (String) tagField.get(null);
        Log.e(TAG, "fieldMethodUse  tagField.get(student):" + tagstr);
    }

    /**
     * Method类及其用法
     */
    private void reflectionMethod() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.Student");
        Method testMethod = aClass.getMethod("test");
        String testMethodName = testMethod.getName();
        Class<?> declaringTestClass = testMethod.getDeclaringClass();
        Class<?> returnType = testMethod.getReturnType();
//        int modifiers = testMethod.getModifiers();
//        Object defaultValue = testMethod.getDefaultValue();
//        Class<?>[] exceptionTypes = testMethod.getExceptionTypes();
//        Parameter[] parameters = testMethod.getParameters();
        Log.e(TAG, "reflectionMethod testMethod: " + testMethod);
        Log.e(TAG, "reflectionMethod testMethodName: " + testMethodName);
        Log.e(TAG, "reflectionMethod declaringTestClass: " + declaringTestClass);
        Log.e(TAG, "reflectionMethod returnType: " + returnType);

        Method multiplyMethod = aClass.getMethod("multiply");
        Log.e(TAG, "reflectionMethod multiplyMethod " + multiplyMethod);

        Log.e(TAG, "reflectionMethod: ---------------------------------------");
        Method declaredlearnMethod = aClass.getDeclaredMethod("learn", int.class, String.class);
        Log.e(TAG, "reflectionMethod declaredlearnMethod:" + declaredlearnMethod);
    }

    /**
     * 相应方法的调用
     * 就是通过invoke 干
     */
    private void reflectionMethodUse() throws Exception {
        Class<?> aClass = Class.forName("com.example.dell.javabasedemo.reflection.Student");
        Method multiply = aClass.getMethod("multiply");
        Student student = (Student) aClass.newInstance();
        multiply.invoke(student);
        Method test = aClass.getMethod("test");
        int testReturn = (int) test.invoke(student);
        Log.e(TAG, "reflectionMethodUse testReturn:" + testReturn);

        Method learn = aClass.getDeclaredMethod("learn", int.class, String.class);
        learn.setAccessible(true);
        learn.invoke(student, 200, "Englisng");
    }

    /**
     * Array类的使用
     */
    private void arrayMethod() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //获取数组类型的Class 即int.class
        Class<?> clazz = array.getClass().getComponentType();
        //创建一个具有指定的组件类型和长度的新数组。
        //第一个参数:数组的类型,第二个参数:数组的长度
        Object newArr = Array.newInstance(clazz, 15);
        //获取原数组的长度
        int co = Array.getLength(array);
        //赋值原数组到新数组
        System.arraycopy(array, 0, newArr, 0, co);
        for (int i : (int[]) newArr) {
            Log.e(TAG, "arrayMethod: " + i + ",");
        }
        try {
            Class clazz2 = Class.forName("java.lang.String");
            Object arrayStr = Array.newInstance(clazz2,10);
            Array.set(arrayStr, 6, "hello");
            String str = (String) Array.get(arrayStr, 6);
            Log.e(TAG, "arrayMethod: " + str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
