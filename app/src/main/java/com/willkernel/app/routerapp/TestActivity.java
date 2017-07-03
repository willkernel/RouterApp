package com.willkernel.app.routerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Route;

@Route({"test", "view://test","http://example.com/user", "router://test"})
public class TestActivity extends AppCompatActivity {
    @InjectParam(key = "id")
    String id;
    @InjectParam(key = "status")
    String sts;

    private String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Router.injectParams(this);//自动将Bundle中的数据注入到@InjectParam注解的成员变量。

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(getIntent().getStringExtra("key"));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent();
                mIntent.putExtra("result", "ok");
                setResult(RESULT_OK, mIntent);
                finish();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("id:")
                    .append(id)
                    .append("\n")
                    .append("status:")
                    .append(sts);
            button1.setText(sb.toString());
        }
    }
}