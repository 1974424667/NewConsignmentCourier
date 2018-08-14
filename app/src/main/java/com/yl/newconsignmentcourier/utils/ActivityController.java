package com.yl.newconsignmentcourier.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: activity管理类
 * Copyright  : Copyright (c) 2018
 * Company    : 西安千百网络
 * Author     : yl
 * Date       : 2018/8/14 15:08141
 */
public class ActivityController {
    /**
     * 放activity的集合
     */
    public static List<Activity> activities = new ArrayList<>();

    /**
     * 添加activity到集合的方法
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 从集合中移除activity的方法
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 移除所有activity的方法
     */
    public static void finishAll() {
        for (Activity a : activities) {
            if (!a.isFinishing()) {
                a.finish();
            }
        }
    }


}
