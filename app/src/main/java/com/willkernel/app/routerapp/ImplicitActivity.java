package com.willkernel.app.routerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ImplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        TextView textView = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("id:")
                    .append(bundle.getString("id"))
                    .append("\n")
                    .append("status:")
                    .append(bundle.getString("status"));
            textView.setText(sb.toString());
        }
    }
}
