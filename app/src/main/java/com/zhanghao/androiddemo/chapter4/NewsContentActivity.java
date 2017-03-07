package com.zhanghao.androiddemo.chapter4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsContentActivity extends BaseActivity {

    NewsContentFragment newsContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        Intent intent = getIntent();
        String newsTitle = intent.getStringExtra("news_title");
        String newsContent = intent.getStringExtra("news_content");
        newsContentFragment.refresh(newsTitle, newsContent);
    }

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }
}
