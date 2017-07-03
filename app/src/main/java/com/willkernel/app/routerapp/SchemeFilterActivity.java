package com.willkernel.app.routerapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chenenyu.router.Router;

public class SchemeFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_filter);
        Uri uri = getIntent().getData();
        Router.build(uri).go(this);
        finish();
    }
}
