package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsBottomModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsTopModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.SearchFriendsBottomModel;
import com.example.menglucywhh.myquarter.model.modelclass.SearchFriendsTopModel;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsBottomViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsTopViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsBottomPresenter {
    SearchFriendsBottomModel searchFriendsBottomModel;
    SearchFriendsBottomViewCallBack searchFriendsBottomViewCallBack;
    public SearchFriendsBottomPresenter(SearchFriendsBottomViewCallBack searchFriendsBottomViewCallBack) {
        this.searchFriendsBottomViewCallBack = searchFriendsBottomViewCallBack;
        searchFriendsBottomModel = new SearchFriendsBottomModel();
    }

    public void get(){
        searchFriendsBottomModel.get(new SearchFriendsBottomModelCallBack() {
            @Override
            public void success(SearchFriendsBottomBean searchFriendsBottomBean) {
                searchFriendsBottomViewCallBack.success(searchFriendsBottomBean);
            }

            @Override
            public void failure() {
                searchFriendsBottomViewCallBack.failure();
            }
        });
    }
}
