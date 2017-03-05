package com.zhanghao.androiddemo.chapter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhanghao.androiddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifeCycleTestActivity extends AppCompatActivity {

    private static final String TAG = "LifeCycleTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_test);
        ButterKnife.bind(this);

        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "=================================");
        Log.d(TAG, new Exception().getStackTrace()[0].getMethodName());
        Log.d(TAG, "=================================");
    }

    @OnClick(R.id.btn_1) void methodForButton1() {
        Intent intent = new Intent(this, NormalActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_2) void methodForButton2() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}
