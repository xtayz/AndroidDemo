package com.zhanghao.androiddemo.chapter5;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhanghao.androiddemo.base.BaseActivity;

/**
 * Created by haozhang on 2017/3/8.
 */

public class BaseActivity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

}
