package com.zhanghao.androiddemo.chapter6;

import android.content.SharedPreferences;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.OnClick;

public class SharedPreferencesTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_test);
    }

    @OnClick(R.id.save_data) void onClickedSaveButton() {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("name", "Tom");
        editor.putInt("age", 28);
        editor.putBoolean("married", false);
        editor.apply();
    }

    @OnClick(R.id.restore_data) void onClickedRestoreButton() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        String name = pref.getString("name", "");
        int age = pref.getInt("age", 0);
        boolean married = pref.getBoolean("married", false);
        Toast.makeText(this, String.format("name: %s, age: %d, married: %b", name, age, married), Toast.LENGTH_SHORT).show();
    }
}
