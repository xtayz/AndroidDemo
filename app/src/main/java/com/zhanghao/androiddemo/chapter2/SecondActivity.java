package com.zhanghao.androiddemo.chapter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.zhanghao.androiddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        // 使用ButterKnife不能忘记这一行
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if (data != null) {
            TextView tv = (TextView) findViewById(R.id.tv_1);
            tv.setText(data);
            Log.d(TAG, data);
        }
    }

    @OnClick(R.id.btn_1)
    void methodForButton() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity!");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        // 写super.OnBackPressed()的话，后面的方法就不执行了，Activity已经finished了
//        super.onBackPressed();
        methodForButton();
    }
}
