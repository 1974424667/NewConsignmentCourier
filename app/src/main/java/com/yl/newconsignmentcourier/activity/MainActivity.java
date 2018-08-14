package com.yl.newconsignmentcourier.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;

import com.yl.newconsignmentcourier.R;
import com.yl.newconsignmentcourier.factory.FragmentFactory;

/**
 * Description:主页面
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton mNewAdvisory, mClewrePorted, mInformationCollection, mPersonalInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();      //取消设置透明状态栏,使 ContentView 内容不再沉浸到状态栏下
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);      //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_main);
        initView();
        //默认选中
        setCurrentFragment(0);

    }

    private void initView() {
        mNewAdvisory = (RadioButton) findViewById(R.id.rd_newadvisory);
        mClewrePorted = (RadioButton) findViewById(R.id.rd_clewreported);
        mInformationCollection = (RadioButton) findViewById(R.id.rd_informationcollection);
        mPersonalInformation = (RadioButton) findViewById(R.id.rd_personalinformation);
        mNewAdvisory.setOnClickListener(this);
        mClewrePorted.setOnClickListener(this);
        mInformationCollection.setOnClickListener(this);
        mPersonalInformation.setOnClickListener(this);
    }


    //加载fagment
    private void setCurrentFragment(int position) {
        //得到要显示的fragment
        Fragment fragment = FragmentFactory.getFragment(position);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();//通过FragmentManager得到fragment事务
        transaction.replace(R.id.fl_content, fragment);                //将fragment放到content_home中进行显示
        transaction.commit();                                   //将事务进行提交
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rd_newadvisory:
                setCurrentFragment(0);
                break;
            case R.id.rd_clewreported:
                setCurrentFragment(1);
                break;
            case R.id.rd_informationcollection:
                setCurrentFragment(2);
                break;
            case R.id.rd_personalinformation:
                setCurrentFragment(3);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
