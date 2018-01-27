package com.example.menglucywhh.myquarter.model;

import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.bean.SatinBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MK on 2018/1/25.
 */

public class SatinModel {
//    https://www.zhaoapi.cn/quarter/getJokes?page=1&source=android&appVersion=101
    public void getData(final IModel iModel){
        Map<String, String> map = new HashMap<>();
        map.put("page","1");
        map.put("appVersion","101");
        map.put("Source","android");
        APIFactory.getInstance().post("/quarter/getJokes", map, new AbstractObserver<SatinBean>() {
            @Override
            public void onSuccess(SatinBean satinBean) {
                iModel.success(satinBean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(SatinBean bean);
        public void failrue();
    }
}
