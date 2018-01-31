package com.example.menglucywhh.myquarter.common;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by muhanxi on 17/12/5.
 * @author muhanxi
 */

public class OkHttpUtils {


    private static OkHttpClient client = null ;


    public static OkHttpClient getInstance(){

        if(client == null){
            synchronized (OkHttpUtils.class){
                if(client == null){
                    client = new OkHttpClient.Builder()
                            .connectTimeout(20000, TimeUnit.SECONDS)
                            .writeTimeout(20000,TimeUnit.SECONDS)
                            .readTimeout(20000,TimeUnit.SECONDS)
                            //.addInterceptor(new CommonHeaderInterceptor())
                           // .addInterceptor(new LoggingInterceptor())
                            .build();
                }
            }
        }
        return client;
    }


}
