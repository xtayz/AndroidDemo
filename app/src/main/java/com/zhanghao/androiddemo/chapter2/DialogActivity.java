package com.zhanghao.androiddemo.chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhanghao.androiddemo.R;

public class DialogActivity extends AppCompatActivity {

    private static final String TAG = "DialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

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

}
