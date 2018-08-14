package com.yl.newconsignmentcourier.utils;

/**
 * Description:避免重复提交数据等待2秒
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class SingleClick {
    public static final int DEFAULT_TIME =2000;
    public static long lastTime;

    public static boolean isSingle() {
        boolean isSingle;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime <= DEFAULT_TIME) {
            isSingle = true;
        } else {
            isSingle = false;
        }
        lastTime = currentTime;
        return isSingle;
    }
}