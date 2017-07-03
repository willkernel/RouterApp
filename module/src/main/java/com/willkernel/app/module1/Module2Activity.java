package com.willkernel.app.module1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;

@Route("module2")
public class Module2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        Fragment fragment = (Fragment) Router.build("fragment1").getFragment(this);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_module2, fragment).commit();
        }
    }
}
