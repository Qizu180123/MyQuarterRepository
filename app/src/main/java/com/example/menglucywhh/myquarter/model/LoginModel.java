package com.example.menglucywhh.myquarter.model;

import com.example.menglucywhh.myquarter.bean.Login_Bean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/1/30.
 */

public class LoginModel {
    public void getData(final IModel regModel ,String name,String pwd){
        Map<String, String> map = new HashMap<>();
        map.put("mobile",name);
        map.put("password",pwd);
        APIFactory.getInstance().post("/user/login",map ,new AbstractObserver<Login_Bean>() {
            @Override
            public void onSuccess(Login_Bean bean) {
                regModel.success(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(Login_Bean bean);
        public void failrue();
    }



}
