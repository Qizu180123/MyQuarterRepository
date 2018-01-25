package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.model.HotVideosModel;
import com.example.menglucywhh.myquarter.view.IView.HotVideosView;

/**
 * Created by MK on 2018/1/25.
 */

public class HotVideosPresenter {
    HotVideosView view;
    private final HotVideosModel model;

    public HotVideosPresenter(HotVideosView view) {
        this.view = view;
        model = new HotVideosModel();
    }
    public void HotVideos(){
        model.getData(new HotVideosModel.IModel() {
            @Override
            public void success(HotVideosBean bean) {
                view.success(bean);
            }

            @Override
            public void failrue() {

            }
        });
    }
}
