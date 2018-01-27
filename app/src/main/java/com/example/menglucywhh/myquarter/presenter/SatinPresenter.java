package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.bean.SatinBean;
import com.example.menglucywhh.myquarter.model.HotVideosModel;
import com.example.menglucywhh.myquarter.model.SatinModel;
import com.example.menglucywhh.myquarter.view.IView.HotVideosView;
import com.example.menglucywhh.myquarter.view.IView.SatinView;

/**
 * Created by MK on 2018/1/25.
 */

public class SatinPresenter {
    SatinView view;
    private final SatinModel model;

    public SatinPresenter(SatinView view) {
        this.view = view;
        model = new SatinModel();
    }
    public void satin(){
        model.getData(new SatinModel.IModel() {
            @Override
            public void success(SatinBean bean) {
                view.success(bean);
            }

            @Override
            public void failrue() {

            }
        });
    }
}
