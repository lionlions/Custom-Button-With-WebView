package com.example.custombuttonwithwebview;

import com.example.custombackbuttonwithwebview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Start extends Activity{

    private final String TAG = "Start";

    private Button mStart;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        processView();
        processListener();

    }

    private void processView() {

        mStart = (Button)findViewById(R.id.btn_start);

    }

    private void processListener() {

        mStart.setOnClickListener(mButtonClickListener);

    }

    private final OnClickListener mButtonClickListener = new OnClickListener() {

        @Override
        public void onClick(final View v) {

            final int id = v.getId();
            switch (id) {
                case R.id.btn_start:
                    final Intent intent = new Intent();
                    intent.setClass(Start.this, CustomButtonWithWebView.class);
                    startActivity(intent);
                    break;
            }

        }
    };

}
