package com.zhanghao.androiddemo.chapter4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhanghao.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wonderworld on 2017/3/7.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @BindView(R.id.visibility_layout)
    View visibilityLayout;

    @BindView(R.id.news_title)
    TextView newsTitleText;

    @BindView(R.id.news_content)
    TextView newsContentText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        visibilityLayout.setVisibility(View.VISIBLE);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }

}
