package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.AdBean;
import com.example.menglucywhh.myquarter.model.AdModel;
import com.example.menglucywhh.myquarter.view.IView.AdView;

/**
 * Created by MK on 2018/1/25.
 */

public class AdPresenter {
    AdView view;
    private final AdModel model;

    public AdPresenter(AdView view) {
        this.view = view;
        model = new AdModel();
    }
    public void ad(){
        model.getData(new AdModel.IModel() {
            @Override
            public void success(AdBean bean) {
                view.success(bean);
            }

            @Override
            public void failrue() {

            }
        });
    }
    //防止内存遗漏
    public void datach(){
        this.view = null;
    }
}
