package com.example.menglucywhh.myquarter.model;

import com.example.menglucywhh.myquarter.bean.Reg_Bean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/1/30.
 */

public class RegModel {
    public void getData(final IModel regModel ,String name,String pwd){
        Map<String, String> map = new HashMap<>();
        map.put("mobile",name);
        map.put("password",pwd);
        APIFactory.getInstance().post("/quarter/register",map ,new AbstractObserver<Reg_Bean>() {
            @Override
            public void onSuccess(Reg_Bean bean) {
                regModel.success(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(Reg_Bean bean);
        public void failrue();
    }



}
