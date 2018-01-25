package com.example.menglucywhh.myquarter.model;

import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.common.APIFactory;
import com.example.menglucywhh.myquarter.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MK on 2018/1/25.
 */

public class HotVideosModel {
    public void getData(final IModel iModel){
        Map<String, String> map = new HashMap<>();
        map.put("page","1");
        map.put("appVersion","101");
        map.put("Source","android");
        APIFactory.getInstance().post("/quarter/getVideos", map, new AbstractObserver<HotVideosBean>() {
            @Override
            public void onSuccess(HotVideosBean hotVideosBean) {
                iModel.success(hotVideosBean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(HotVideosBean bean);
        public void failrue();
    }
}
