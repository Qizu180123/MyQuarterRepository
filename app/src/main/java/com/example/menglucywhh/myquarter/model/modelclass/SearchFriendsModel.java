package com.example.menglucywhh.myquarter.model.modelclass;

import com.example.menglucywhh.myquarter.bean.SearchFriendsBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsBottomModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsModelCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsModel {
    public void get(String zhongYouName, final SearchFriendsModelCallBack searchFriendsModelCallBack) {
        //调用封装好的请求网络数据
        //请求关注的用户数据
//        不需要根据keywords查询
//  https://www.zhaoapi.cn/quarter/searchFriends?source=android&keywords=王&appVersion=101

        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("keywords", zhongYouName);

        String url="/quarter/searchFriends";
        APIFactory.getInstance().get(url, map, new AbstractObserver<SearchFriendsBean>() {
            @Override
            public void onSuccess(SearchFriendsBean searchFriendsBean){
                if(searchFriendsBean!=null){
                    // System.out.println(myAttentionBean.getData().get(0).getUsername());
                    //回调出去
                    searchFriendsModelCallBack.success(searchFriendsBean);
                }
            }

            @Override
            public void onFailure(int code) {

                searchFriendsModelCallBack.failure();
            }
        });
    }
}
