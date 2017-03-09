package com.zhanghao.androiddemo.chapter5;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haozhang on 2017/3/8.
 */

public class ActivityController {

    public static List<Activity> activites = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activites.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activites.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activites) {
            if (!activity.isFinishing()) {
                try {
                    activity.finish();
                    Log.d("finishAll", "finishAll");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        activites.clear();
    }

}
