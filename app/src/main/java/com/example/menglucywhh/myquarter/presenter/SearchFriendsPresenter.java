package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.SearchFriendsBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsBottomModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.SearchFriendsModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.SearchFriendsBottomModel;
import com.example.menglucywhh.myquarter.model.modelclass.SearchFriendsModel;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsBottomViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsPresenter {
    SearchFriendsModel searchFriendsModel;
    SearchFriendsViewCallBack searchFriendsViewCallBack;
    public SearchFriendsPresenter(SearchFriendsViewCallBack searchFriendsViewCallBack) {
        this.searchFriendsViewCallBack = searchFriendsViewCallBack;
        searchFriendsModel = new SearchFriendsModel();
    }

    public void get(String zhongYouName){
        searchFriendsModel.get(zhongYouName,new SearchFriendsModelCallBack() {
            @Override
            public void success(SearchFriendsBean searchFriendsBean) {
                searchFriendsViewCallBack.success(searchFriendsBean);
            }

            @Override
            public void failure() {
                searchFriendsViewCallBack.failure();
            }
        });
    }
}
