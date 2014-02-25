
package com.example.custombuttonwithwebview;

import com.example.custombackbuttonwithwebview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class CustomButtonWithWebView extends Activity {

    private final String TAG = "CustomBackButtonWithWebView";

    private ImageButton mBack;
    private ImageButton mNext;
    private WebView mWebView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_back_button_with_web_view);

        processView();
        processListener();

    }

    private void processView() {

        mBack = (ImageButton)findViewById(R.id.btn_back);
        mNext = (ImageButton)findViewById(R.id.btn_next);
        mWebView = (WebView)findViewById(R.id.webview);

    }

    private void processListener() {

        mBack.setOnClickListener(mButtonClickListener);
        mNext.setOnClickListener(mButtonClickListener);

        processWebView();

    }

    private void processWebView() {

        final String url = "http://yahoo.com.tw";
        final WebSettings webSettings = mWebView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(url);

    }

    private final OnClickListener mButtonClickListener = new OnClickListener() {

        @Override
        public void onClick(final View v) {

            final int id = v.getId();
            switch (id) {
                case R.id.btn_back:
                    if(mWebView.canGoBack()){
                        mWebView.goBack();
                    }else{
                        finish();
                    }
                    break;
                case R.id.btn_next:
                    if(mWebView.canGoForward()){
                        mWebView.goForward();
                    }
                    break;
            }

        }
    };

    @Override
    public void onBackPressed() {

        if(mWebView.canGoBack()){
            mWebView.goBack();
            return;
        }

        super.onBackPressed();

    };

}
