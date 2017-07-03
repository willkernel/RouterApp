package com.willkernel.app.routerapp;

import android.app.Application;

import com.chenenyu.router.Router;

/**
 * Created by willkernel on 2017/7/1.
 * mail:willkerneljc@gmail.com
 */

public class CApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Router.setDebuggable(true);
        Router.initialize(this);
    }
}