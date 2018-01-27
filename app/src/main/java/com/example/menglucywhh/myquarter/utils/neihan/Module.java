package com.example.menglucywhh.myquarter.utils.neihan;

import com.example.menglucywhh.myquarter.bean.NeihanVideoBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by QinQinBaoBei on 2018/1/25.
 */

public class Module {

    public void getData(final NhVideoModuleListener nhVideoModuleListener){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("http://lf.snssdk.com/neihan/stream/mix/v1/?content_type=-104")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                NeihanVideoBean neihanVideoBean = new Gson().fromJson(string, NeihanVideoBean.class);
                if(nhVideoModuleListener!=null){
                    nhVideoModuleListener.success(neihanVideoBean);
                }
            }
        });
    }
    public interface NhVideoModuleListener{
        void success(NeihanVideoBean bean);
    }
}
