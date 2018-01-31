package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;
import com.example.menglucywhh.myquarter.model.callback.MyAttentionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsTopModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.MyAttentionModel;
import com.example.menglucywhh.myquarter.model.modelclass.SearchFriendsTopModel;
import com.example.menglucywhh.myquarter.view.activity.SearchFriendsActivity;
import com.example.menglucywhh.myquarter.view.callback.MyAttentionViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsTopViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsTopPresenter {
    SearchFriendsTopModel searchFriendsTopModel;
    SearchFriendsTopViewCallBack searchFriendsTopViewCallBack;

    public SearchFriendsTopPresenter(SearchFriendsTopViewCallBack searchFriendsTopViewCallBack) {
        this.searchFriendsTopViewCallBack = searchFriendsTopViewCallBack;
        searchFriendsTopModel = new SearchFriendsTopModel();
    }

    public void get(){
        searchFriendsTopModel.get(new SearchFriendsTopModelCallBack() {
            @Override
            public void success(SearchFriendsTopBean searchFriendsTopBean) {
                searchFriendsTopViewCallBack.success(searchFriendsTopBean);
            }

            @Override
            public void failure() {
                searchFriendsTopViewCallBack.failure();
            }
        });
    }
}
