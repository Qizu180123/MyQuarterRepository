package com.example.menglucywhh.myquarter.model.callback;

import com.example.menglucywhh.myquarter.bean.VersionBean;

/**
 * Created by Menglucywhh on 2018/2/1.
 */

public interface VersionModelCallBack {
    public void success(VersionBean versionBean);
    public void failure();
}
