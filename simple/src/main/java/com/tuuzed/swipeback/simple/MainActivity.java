package com.tuuzed.swipeback.simple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.tuuzed.swipeback.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {
    private static final String PAGE = "page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textPage = (TextView) findViewById(R.id.text_page);
        final int page = getIntent().getIntExtra(PAGE, 0);
        setSwipeBackEnable(page != 0);
        if (page == 0) {
            textPage.setVisibility(View.GONE);
        } else {
            textPage.setVisibility(View.VISIBLE);
            textPage.setText("Page:" + page);
        }
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(PAGE, page + 1);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollToFinishActivity();
            }
        });
    }

}
