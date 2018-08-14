package com.yl.newconsignmentcourier.activity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.yl.newconsignmentcourier.R;
import com.yl.newconsignmentcourier.utils.Utils;


/**
 * Description:闪屏界面
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class SplashActivity extends AppCompatActivity {
    private ImageView mIvRoot;
    public static boolean startApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startApp = true;
        //渐变动画
        mIvRoot = (ImageView) findViewById(R.id.re_root);
        openAnimation();
    }

    //开机动画
    private void openAnimation() {
        //版本名
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1);
        alphaAnimation.setDuration(1000);
        mIvRoot.startAnimation(alphaAnimation);
        //动画监听
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //动画结束开启登录界面
            @Override
            public void onAnimationEnd(Animation animation) {
                startLoginActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    //登录界面
    private void startLoginActivity() {
        startActivity(new Intent(Utils.getContext(), LoginActivity.class));
        //取消默认界面切换动画
        overridePendingTransition(0, 0);
        finish();
    }

    //回退按钮禁用
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
