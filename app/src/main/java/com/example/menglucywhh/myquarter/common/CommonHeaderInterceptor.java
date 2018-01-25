package com.example.menglucywhh.myquarter.common;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by muhanxi on 17/12/5.
 */

public class CommonHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request =  chain.request();

        Request.Builder builder =  request.newBuilder() ;

        builder.addHeader("key","1909D");
        builder.addHeader("User-Agent","android");

        return chain.proceed(builder.build());
    }
}
