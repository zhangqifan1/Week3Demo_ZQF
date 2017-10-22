package com.bawei.week3demo_zqf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class ThingsActivity extends Activity implements View.OnClickListener {

    private WebView mWebview;
    /**
     * 异常
     */
    private Button mBut;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things);
        initView();
        String name = getIntent().getStringExtra("name");
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        mWebview.loadUrl(name);
        mWebview.getSettings().setJavaScriptEnabled(true);
//        mWebview.loadUrl("javascript:changeInputValue('大大')");
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                Object o=null;
                System.out.println(o.toString());
                break;
        }
    }
}
