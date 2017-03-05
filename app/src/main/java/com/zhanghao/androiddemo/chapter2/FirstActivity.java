package com.zhanghao.androiddemo.chapter2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    @BindView(R.id.button_1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_1)
    void methodForButton1() {
        Toast.makeText(this, "显式Intent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("extra_data", "Hello SecondActivity!");
//        startActivity(intent);
        startActivityForResult(intent, 1);
    }

    @OnClick(R.id.button_2)
    void methodForButton2() {
        Toast.makeText(this, "隐式Intent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent("com.zhanghao.androiddemo.ACTION_START");
        intent.addCategory("com.emample.androiddemo.MY_CATEGORY");
        startActivity(intent);
    }

    @OnClick(R.id.button_3)
    void methodForButton3() {
        Toast.makeText(this, "打开网页", Toast.LENGTH_SHORT).show();
        // 让用户选择浏览器打开网页
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    @OnClick(R.id.button_4)
    void methodForButton4() {
        Toast.makeText(this, "拨打电话", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }

    @OnClick(R.id.button_5) void methodForButton5() {
        Intent intent = new Intent(this, LifeCycleTestActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(this, "You clicked add!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "You clicked remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
