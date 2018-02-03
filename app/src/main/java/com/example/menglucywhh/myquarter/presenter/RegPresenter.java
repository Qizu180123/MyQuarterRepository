package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.Reg_Bean;
import com.example.menglucywhh.myquarter.model.RegModel;
import com.example.menglucywhh.myquarter.view.IView.RegView;

/**
 * Created by Lenovo on 2018/1/30.
 */

public class RegPresenter {
    RegView view;
    private final RegModel model;

    public RegPresenter(RegView view) {
        this.view = view;
        model = new RegModel();
    }
    public void HotVideos(String name,String pwd){
        model.getData(new RegModel.IModel() {
            @Override
            public void success(Reg_Bean bean) {
                view.success(bean);


            }

            @Override
            public void failrue() {



            }
        },name,pwd);
    }

}
