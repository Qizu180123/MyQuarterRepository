package com.example.menglucywhh.myquarter.model;



import com.example.menglucywhh.myquarter.bean.shipingBean;
import com.example.menglucywhh.myquarter.utils.common.APIFactory;
import com.example.menglucywhh.myquarter.utils.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuck on 2018/1/22.
 */

public class AddModel {
    public void getData(final IModel iModel){
        Map<String, String> map = new HashMap<>();
//       Page=0&tokeaan=44ECB7BF74853A20D62CF8279AB2AEE1&source=android&appVersion=101
        map.put("Page","1");
        map.put("type","1");
        map.put("Source","android");
        map.put("appVersion","101");
        APIFactory.getInstance().post("/quarter/getVideos", map, new AbstractObserver<shipingBean>() {
            @Override
            public void onSuccess(shipingBean addBean) {
                iModel.success(addBean);
            }

            @Override
            public void onFailure(int code) {

            }


        });
    }



    public interface IModel{
        //成功 失败
        public void success(shipingBean bean);
        public void failrue();
    }
}