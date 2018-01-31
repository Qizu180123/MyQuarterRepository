package com.example.menglucywhh.myquarter.model.modelclass;

import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;
import com.example.menglucywhh.myquarter.model.callback.MyAttentionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsTopModelCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsTopModel {
    public void get(final SearchFriendsTopModelCallBack searchFriendsTopModelCallBack) {
        //调用封装好的请求网络数据
        //请求关注的用户数据
//        不需要根据keywords查询
//        https://www.zhaoapi.cn/quarter/searchFriends?appVersion=101&source=android

        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("keywords", "李");

        String url="/quarter/searchFriends";
        APIFactory.getInstance().get(url, map, new AbstractObserver<SearchFriendsTopBean>() {
            @Override
            public void onSuccess(SearchFriendsTopBean searchFriendsTopBean) {
                if(searchFriendsTopBean!=null){
                    // System.out.println(myAttentionBean.getData().get(0).getUsername());
                    //回调出去
                    searchFriendsTopModelCallBack.success(searchFriendsTopBean);
                }
            }

            @Override
            public void onFailure(int code) {

                searchFriendsTopModelCallBack.failure();
            }
        });
    }
}
