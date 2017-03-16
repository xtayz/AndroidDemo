package com.zhanghao.androiddemo.chapter9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhanghao.androiddemo.R;
import com.zhanghao.androiddemo.base.BaseActivity;

import butterknife.BindView;

public class WebViewTest extends BaseActivity {

    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_test);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.baidu.com");
    }

}
