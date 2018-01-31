package com.example.menglucywhh.myquarter.model.modelclass;

import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;
import com.example.menglucywhh.myquarter.model.callback.MyAttentionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.MyCollectionModelCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyCollectionModel {
    public void get(final MyCollectionModelCallBack myCollectionModelCallBack) {
 //https://www.zhaoapi.cn/quarter/getFavorites?uid=1650&source=android&appVersion=101&token=2FC3EF31EA25696D2715A971ADE38DE1
        //调用封装好的请求网络数据
        //请求关注的用户数据
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("token", "2FC3EF31EA25696D2715A971ADE38DE1");
        map.put("uid", "1650");

        String url="/quarter/getFavorites";
        APIFactory.getInstance().get(url, map, new AbstractObserver<MyCollectionBean>() {
            @Override
            public void onSuccess(MyCollectionBean myCollectionBean) {
                if(myCollectionBean!=null){
                    // System.out.println(myAttentionBean.getData().get(0).getUsername());
                    //回调出去
                    myCollectionModelCallBack.success(myCollectionBean);
                }
            }

            @Override
            public void onFailure(int code) {

                myCollectionModelCallBack.failure();
            }
        });
    }
}
