package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.model.callback.MyAttentionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.MyCollectionModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.MyAttentionModel;
import com.example.menglucywhh.myquarter.model.modelclass.MyCollectionModel;
import com.example.menglucywhh.myquarter.view.activity.MyCollectionActivity;
import com.example.menglucywhh.myquarter.view.callback.MyAttentionViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.MyCollectionViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyCollectionPresenter {
    MyCollectionModel myCollectionModel;
    MyCollectionViewCallBack myCollectionViewCallBack;

    public MyCollectionPresenter(MyCollectionViewCallBack myCollectionViewCallBack) {
        this.myCollectionViewCallBack = myCollectionViewCallBack;
        myCollectionModel = new MyCollectionModel();
    }

    public void get(){
        myCollectionModel.get(new MyCollectionModelCallBack() {
            @Override
            public void success(MyCollectionBean myCollectionBean) {
                myCollectionViewCallBack.success(myCollectionBean);
            }

            @Override
            public void failure() {
                myCollectionViewCallBack.failure();
            }
        });
    }
}
