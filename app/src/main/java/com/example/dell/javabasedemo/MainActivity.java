package com.example.dell.javabasedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dell.javabasedemo.activity.AnnotationActivity;
import com.example.dell.javabasedemo.activity.AnnotationProcessorActivity;
import com.example.dell.javabasedemo.activity.BitOperationActivity;
import com.example.dell.javabasedemo.activity.ClassloaderActivity;
import com.example.dell.javabasedemo.activity.CollectionActivity;
import com.example.dell.javabasedemo.activity.GenericActivity;
import com.example.dell.javabasedemo.activity.QueueActivity;
import com.example.dell.javabasedemo.activity.ReflectionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Context mContext;
    private Button bt_bit_operations;
    private Button bt_collection;
    private Button bt_Queue;
    private Button bt_reflection;
    private Button bt_annotation;
    private Button bt_generic;
    private Button bt_annotation_Processor;
    private Button bt_classloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        bt_bit_operations = (Button) findViewById(R.id.bt_bit_operations);
        bt_collection = (Button) findViewById(R.id.bt_collection);
        bt_Queue = (Button) findViewById(R.id.bt_Queue);
        bt_reflection = (Button) findViewById(R.id.bt_reflection);
        bt_generic = (Button) findViewById(R.id.bt_generic);
        bt_annotation = (Button) findViewById(R.id.bt_annotation);
        bt_annotation_Processor = (Button) findViewById(R.id.bt_annotation_Processor);
        bt_classloader = (Button) findViewById(R.id.bt_classloader);

        bt_bit_operations.setOnClickListener(this);
        bt_collection.setOnClickListener(this);
        bt_Queue.setOnClickListener(this);
        bt_reflection.setOnClickListener(this);
        bt_generic.setOnClickListener(this);
        bt_annotation.setOnClickListener(this);
        bt_annotation_Processor.setOnClickListener(this);
        bt_classloader.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_bit_operations:
                startActivity(new Intent(mContext, BitOperationActivity.class));
                break;
            case R.id.bt_collection:
                startActivity(new Intent(mContext, CollectionActivity.class));
                break;
            case R.id.bt_Queue:
                startActivity(new Intent(mContext, QueueActivity.class));
                break;
            case R.id.bt_reflection:
                startActivity(new Intent(mContext, ReflectionActivity.class));
                break;
            case R.id.bt_generic:
                startActivity(new Intent(mContext, GenericActivity.class));
                break;
            case R.id.bt_annotation:
                startActivity(new Intent(mContext, AnnotationActivity.class));
                break;
            case R.id.bt_annotation_Processor:
                startActivity(new Intent(mContext, AnnotationProcessorActivity.class));
                break;
            case R.id.bt_classloader:
                startActivity(new Intent(mContext, ClassloaderActivity.class));
                break;
        }
    }
}
