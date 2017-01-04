package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 非Activity的class不用再Mainfest.xml中注册，在使用时直接new生成事例即可，但是注意一个问题
 * 1.本例中的Fragment1如果在MainActivity中实例化的话会报运行异常，系统会奔溃，原因目前我的理解是
 * 在生成Activity时 layout是对应生成的，中间一定有注册机制，相应的非Activity对应的类（如本例中的Fragment1）
 * 只能在有相关注册信息的Acitity中实例化，否则存在逻辑错误！
 */

public class Fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
    }
