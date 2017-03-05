package com.zhanghao.androiddemo.chapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhanghao.androiddemo.R;

public class HelloWorldActivity extends AppCompatActivity {

    private static final String TAG = "HelloWorldActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        Log.v(TAG, "onCreate exexute");
        Log.d(TAG, "onCreate exexute");
        Log.i(TAG, "onCreate exexute");
        Log.w(TAG, "onCreate exexute");
        Log.e(TAG, "onCreate exexute");
    }
}
