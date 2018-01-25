package com.example.menglucywhh.myquarter.model;

import com.example.menglucywhh.myquarter.bean.AdBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;

/**
 * Created by MK on 2018/1/25.
 */

public class AdModel {
    public void getData(final IModel iModel){
        APIFactory.getInstance().get("https://www.zhaoapi.cn/quarter/getAd", new AbstractObserver<AdBean>() {
            @Override
            public void onSuccess(AdBean bean) {
                iModel.success(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(AdBean bean);
        public void failrue();
    }
}
