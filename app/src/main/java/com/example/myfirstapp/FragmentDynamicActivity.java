package com.example.myfirstapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentDynamicActivity extends AppCompatActivity {
    /**
     * 非Activity的class不用再Mainfest.xml中注册，在使用时直接new生成事例即可，但是注意一个问题
     * 1.本例中的Fragment1如果在MainActivity中实例化的话会报运行异常，系统会奔溃，原因目前我的理解是
     * 在生成Activity时 layout是对应生成的，中间一定有注册机制，相应的非Activity对应的类（如本例中的Fragment1）
     * 只能在有相关注册信息的Acitity中实例化，否则存在逻辑错误！
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);
        Button bt1 = (Button) findViewById(R.id.showDynamicFragment1);
        Button bt2 = (Button) findViewById(R.id.showDynamicFragment2);
        /**获取控件监听器*/
        bt1.setOnClickListener(new View.OnClickListener(){
            /**执行动作*/
            public void onClick(View v) {
                /**生成manager管理对象*/
                FragmentManager manager =getSupportFragmentManager();
                /**开启transaction事务*/
                FragmentTransaction transaction = manager.beginTransaction();
                /**生成Fragment事例*/
                Fragment1 f1 = new Fragment1();
                /**在事务容器中添加Fragment事例*/
                transaction.add(R.id.showDynamicFragment,f1);
                /**提交事务，确定生成*/
                transaction.commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment2 f2 = new Fragment2();
                transaction.add(R.id.showDynamicFragment,f2);
                transaction.commit();
            }
        });

    }
}
