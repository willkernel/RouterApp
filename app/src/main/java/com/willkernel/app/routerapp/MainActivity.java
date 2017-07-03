package com.willkernel.app.routerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chenenyu.router.InterceptorTable;
import com.chenenyu.router.RouteCallback;
import com.chenenyu.router.RouteInterceptor;
import com.chenenyu.router.RouteResult;
import com.chenenyu.router.RouteTable;
import com.chenenyu.router.Router;
import com.chenenyu.router.TargetInterceptors;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements RouteCallback {
    private String TAG = "MainActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        findViewById(R.id.testActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Router.build("test").callback(MainActivity.this).go(mContext);
//                Router.build("test").with("key", "value").callback(MainActivity.this).go(mContext);
//                Router.build("test").with("key", "value").callback(MainActivity.this).requestCode(100).go(mContext);
//                Router.build("view://test").callback(MainActivity.this).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).go(mContext);
//                Router.build("view://test").skipInterceptors().go(mContext);
//                Router.build("dynamic").go(mContext);
//                startActivity(new Intent(mContext, WebActivity.class));
//                Router.build(Uri.parse("router://implicit?id=9527&status=success")).go(mContext);
//                Router.build("module1").go(mContext);
//                Router.build("module2").go(mContext);
                Router.build("intercepted").go(mContext);
            }
        });

        // 动态添加路由
        Router.handleRouteTable(new RouteTable() {
            @Override
            public void handle(Map<String, Class<?>> map) {
                map.put("dynamic", DynamicActivity.class);
            }
        });

        Router.handleInterceptorTable(new InterceptorTable() {
            @Override
            public void handle(Map<String, Class<? extends RouteInterceptor>> map) {
                map.put("SampleInterceptor", SampleInterceptor.class);
            }
        });
        Router.handleTargetInterceptors(new TargetInterceptors() {
            @Override
            public void handle(Map<Class<?>, String[]> map) {
                map.put(InterceptedActivity.class, new String[]{"SampleInterceptor"});
            }
        });

        final Button testActivity_button = (Button) findViewById(R.id.testActivity_button);
        findViewById(R.id.testActivity_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.build(testActivity_button.getText().toString()).go(mContext);
            }
        });
    }

    @Override
    public void callback(RouteResult state, Uri uri, String message) {
        Log.e(TAG, uri.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "requestCode=" + requestCode);
        Log.e(TAG, "resultCode=" + resultCode);
        Log.e(TAG, "data=" + data);
    }
}
