package com.yl.newconsignmentcourier.baseappliction;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;


import com.yl.newconsignmentcourier.utils.LogUtil;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Description:全局生命周期最长
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class BaseApplication extends Application {

    public Context context;
    public static BaseApplication instance;
    public int mainThreadId;
    public Handler handler;
    private ArrayList<Activity> activities = new ArrayList<>();
    private String TAG = "BaseApplication";


    @Override
    public void onCreate() {
        super.onCreate();
        try {
            initHttp();  //初始化网络请求
        } catch (Exception e) {
            e.printStackTrace();
        }
        context = getApplicationContext(); //获取全局Context对象
        handler = new Handler();
        mainThreadId = android.os.Process.myTid(); //获取主线程的线程id
        instance = this;//Application对象的创建是有系统来完成，不能自己new出Application的实例对象
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());//捕获全局异常

    }
    //初始化http网络请求
    private void initHttp() {
    }




    class ExceptionHandler implements Thread.UncaughtExceptionHandler {
        //一旦出现未捕获异常,就会走到此方法中
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            LogUtil.i("发现一个未处理的异常", "");
            ex.printStackTrace();
            //收集错误日志, 自动将错误日志文件上传到服务器
            PrintWriter writer;
            try {
                writer = new PrintWriter(new File(Environment
                        .getExternalStorageDirectory().getAbsolutePath()
                        + "/IWISerr.txt"));
                ex.printStackTrace(writer);
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //结束当前进程, 闪退
            //System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

}