package com.example.menglucywhh.myquarter.model.callback;

import com.example.menglucywhh.myquarter.bean.SearchFriendsBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;

public interface SearchFriendsModelCallBack {
    public void success(SearchFriendsBean searchFriendsBean);
    public void failure();
}