package com.yl.newconsignmentcourier.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yl.newconsignmentcourier.activity.SplashActivity;
import com.yl.newconsignmentcourier.utils.Utils;


/**
 * Description:  开机广播
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class StartPhoneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //开机广播
        String action = intent.getAction();
        if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            //跳转闪屏界面
            Intent i = new Intent(Utils.getContext(), SplashActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
