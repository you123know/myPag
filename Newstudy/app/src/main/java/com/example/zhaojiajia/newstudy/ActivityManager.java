package com.example.zhaojiajia.newstudy;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/9.
 */
public class ActivityManager {
    private static List<Activity> list = new ArrayList<Activity>();

    public static void add(Activity activity) {
        list.add(activity);
    }

    public static void closeAll() {
        for (int a = 0; a < list.size(); a++) {
            if (!list.get(a).isFinishing()) {
                list.get(a).finish();
            }
        }
    }
}
