package com.example.menglucywhh.myquarter.model.modelclass;

import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.bean.VersionBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;
import com.example.menglucywhh.myquarter.model.callback.MyCollectionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.VersionModelCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class VersionModel {
    public void get(final VersionModelCallBack versionModelCallBack) {
      //https://www.zhaoapi.cn/quarter/getVersion?appVersion=101&source=android
        //调用封装好的请求网络数据
        //请求关注的用户数据
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");

        String url="/quarter/getVersion";
        APIFactory.getInstance().get(url, map, new AbstractObserver<VersionBean>() {
            @Override
            public void onSuccess(VersionBean versionBean) {
                if(versionBean!=null){
                    // System.out.println(myAttentionBean.getData().get(0).getUsername());
                    //回调出去
                    versionModelCallBack.success(versionBean);
                }
            }

            @Override
            public void onFailure(int code) {

                versionModelCallBack.failure();
            }
        });
    }
}
