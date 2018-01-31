package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.model.callback.MyAttentionModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.MyAttentionModel;
import com.example.menglucywhh.myquarter.view.activity.MyAttentionActivity;
import com.example.menglucywhh.myquarter.view.callback.MyAttentionViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyAttentionPresenter {
    MyAttentionModel myAttentionModel;
    MyAttentionViewCallBack myAttentionViewCallBack;
    public MyAttentionPresenter(MyAttentionViewCallBack myAttentionViewCallBack) {
        this.myAttentionViewCallBack = myAttentionViewCallBack;
        myAttentionModel = new MyAttentionModel();
    }

    public void get(){
        myAttentionModel.get(new MyAttentionModelCallBack() {
            @Override
            public void success(MyAttentionBean myAttentionBean) {
                myAttentionViewCallBack.success(myAttentionBean);
            }

            @Override
            public void failure() {
                myAttentionViewCallBack.failure();
            }
        });
    }
}
