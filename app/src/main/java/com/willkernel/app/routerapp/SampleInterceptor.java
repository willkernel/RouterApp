package com.willkernel.app.routerapp;

import android.content.Context;
import android.widget.Toast;

import com.chenenyu.router.RouteInterceptor;
import com.chenenyu.router.RouteRequest;
import com.chenenyu.router.annotation.Interceptor;

/**
 * Created by willkernel on 2017/7/3.
 * mail:willkerneljc@gmail.com
 */
@Interceptor("SampleInterceptor")
public class SampleInterceptor implements RouteInterceptor {
    @Override
    public boolean intercept(Context context, RouteRequest routeRequest) {
        Toast.makeText(context,"interceptor by Sample",Toast.LENGTH_LONG).show();
        return true;
    }
}
