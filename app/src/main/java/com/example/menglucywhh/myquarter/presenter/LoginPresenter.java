package com.example.menglucywhh.myquarter.presenter;

import com.example.menglucywhh.myquarter.bean.Login_Bean;
import com.example.menglucywhh.myquarter.model.LoginModel;
import com.example.menglucywhh.myquarter.view.IView.LoginView;

/**
 * Created by Lenovo on 2018/1/30.
 */

public class LoginPresenter {
    LoginView view;
    private final LoginModel model;

    public LoginPresenter(LoginView view) {
        this.view = view;
        model = new LoginModel();
    }
    public void HotVideos(String name,String pwd){
        model.getData(new LoginModel.IModel() {
            @Override
            public void success(Login_Bean bean) {
                view.success(bean);


            }

            @Override
            public void failrue() {



            }
        },name,pwd);
    }

}
