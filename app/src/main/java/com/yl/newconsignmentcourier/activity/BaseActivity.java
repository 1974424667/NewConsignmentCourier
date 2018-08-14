package com.yl.newconsignmentcourier.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yl.newconsignmentcourier.R;
import com.yl.newconsignmentcourier.baseappliction.BaseApplication;
import com.yl.newconsignmentcourier.utils.ActivityController;

/**
 * Description: 所以界面的基类
 * Copyright  : Copyright (c) 2017
 * Company    : 大麦科技
 * Author     : yl
 * Date       : 2017/9/30
 */

public class BaseActivity extends AppCompatActivity {

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







        //打开一个activity就添加一个
        ActivityController.addActivity(this);
        setContentView(R.layout.activity_base);
    }

    //返回键
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.gc();
    }

    //销毁时调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

    /**
     * 替代findviewById方法
     */
    protected <T extends View> T find(int id) {
        return (T) findViewById(id);
    }

}
