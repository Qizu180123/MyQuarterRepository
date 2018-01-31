package com.example.menglucywhh.myquarter.model.modelclass;

import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsBottomModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsTopModelCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsBottomModel {
    public void get(final SearchFriendsBottomModelCallBack searchFriendsBottomModelCallBack) {
        //调用封装好的请求网络数据
        //请求关注的用户数据
//        不需要根据keywords查询
//     https://www.zhaoapi.cn/quarter/randomFriends?source=android&appVersion=101

        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");

        String url="/quarter/randomFriends";
        APIFactory.getInstance().get(url, map, new AbstractObserver<SearchFriendsBottomBean>() {
            @Override
            public void onSuccess(SearchFriendsBottomBean searchFriendsBottomBean){
                if(searchFriendsBottomBean!=null){
                    // System.out.println(myAttentionBean.getData().get(0).getUsername());
                    //回调出去
                    searchFriendsBottomModelCallBack.success(searchFriendsBottomBean);
                }
            }

            @Override
            public void onFailure(int code) {

                searchFriendsBottomModelCallBack.failure();
            }
        });
    }
}
