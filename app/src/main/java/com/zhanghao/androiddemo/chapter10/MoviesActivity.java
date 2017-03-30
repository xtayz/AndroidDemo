package com.zhanghao.androiddemo.chapter10;

import android.os.Bundle;
import android.widget.ListView;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.BindView;

public class MoviesActivity extends BaseActivity {

    @BindView(R.id.lv_movie)
    ListView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

}
