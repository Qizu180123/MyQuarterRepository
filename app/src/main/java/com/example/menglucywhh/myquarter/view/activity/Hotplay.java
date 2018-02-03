package com.example.menglucywhh.myquarter.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.menglucywhh.myquarter.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class Hotplay extends AppCompatActivity {

    private JCVideoPlayerStandard jzVideoPlayerStandard;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotplay);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String image = intent.getStringExtra("image");
        jzVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.bofang);
        jzVideoPlayerStandard.setUp(url,jzVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, image);

        jzVideoPlayerStandard.widthRatio = 4;//播放比例
        jzVideoPlayerStandard.heightRatio = 3;



    }

}