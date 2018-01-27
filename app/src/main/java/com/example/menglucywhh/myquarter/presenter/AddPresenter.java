package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.shipingBean;
import com.example.menglucywhh.myquarter.model.AddModel;
import com.example.menglucywhh.myquarter.view.AddView;


/**
 * Created by fuck on 2018/1/22.
 */

public class AddPresenter {
    AddView view;
    private final AddModel model;

    public AddPresenter(AddView view) {
        this.view = view;
        model = new AddModel();
    }

    public void shangpin(){
        model.getData(new AddModel.IModel() {
            @Override
            public void success(shipingBean bean) {
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