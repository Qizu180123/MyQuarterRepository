package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.bean.VersionBean;
import com.example.menglucywhh.myquarter.model.callback.MyCollectionModelCallBack;
import com.example.menglucywhh.myquarter.model.callback.VersionModelCallBack;
import com.example.menglucywhh.myquarter.model.modelclass.MyCollectionModel;
import com.example.menglucywhh.myquarter.model.modelclass.VersionModel;
import com.example.menglucywhh.myquarter.view.activity.SettingsActivity;
import com.example.menglucywhh.myquarter.view.callback.MyCollectionViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.VersionViewCallBack;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class VersionPresenter {
   VersionModel versionModel;
    VersionViewCallBack versionViewCallBack;

    public VersionPresenter(VersionViewCallBack versionViewCallBack) {
        this.versionViewCallBack = versionViewCallBack;
        versionModel = new VersionModel();
    }

    public void get(){
        versionModel.get(new VersionModelCallBack() {
            @Override
            public void success(VersionBean versionBean) {
                versionViewCallBack.success(versionBean);
            }

            @Override
            public void failure() {
                versionViewCallBack.failure();
            }
        });
    }
}
