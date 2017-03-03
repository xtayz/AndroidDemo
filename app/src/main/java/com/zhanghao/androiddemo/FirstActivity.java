package com.zhanghao.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.button_1)
    Button button1;

    @BindString(R.string.button_1) String btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_1)
    void methodForButton() {
        Toast.makeText(this, "You clicked " + btn1, Toast.LENGTH_SHORT).show();
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
