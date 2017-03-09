package com.zhanghao.androiddemo.chapter5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity1 {

    @BindView(R.id.account)
    EditText accountEdit;

    @BindView(R.id.password)
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.login) void onClickedLoginButton() {
        String account = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if (account.equals("admin") && password.equals("123456")) {
            Intent intent = new Intent(this, BroadcastBestPractice.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show();
        }
    }
}
