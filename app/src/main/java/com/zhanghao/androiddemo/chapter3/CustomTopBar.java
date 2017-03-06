package com.zhanghao.androiddemo.chapter3;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.zhanghao.androiddemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wonderworld on 2017/3/6.
 */

public class CustomTopBar extends LinearLayout {

    public CustomTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back) void methodForBackButton() {
        ((Activity)getContext()).finish();
    }
}
