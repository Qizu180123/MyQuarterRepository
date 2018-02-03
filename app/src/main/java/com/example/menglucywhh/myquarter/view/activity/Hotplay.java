package com.example.menglucywhh.myquarter.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.ShareUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class Hotplay extends AppCompatActivity {

    @BindView(R.id.yxh4)
    ImageView yxh4;
    @BindView(R.id.yxh3)
    ImageView yxh3;
    @BindView(R.id.yxh2)
    ImageView yxh2;
    @BindView(R.id.yxh1)
    ImageView yxh1;
    @BindView(R.id.yxh)
    SimpleDraweeView yxh;
    @BindView(R.id.title)
    TextView title;
    private JCVideoPlayerStandard jzVideoPlayerStandard;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotplay);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        String image = intent.getStringExtra("image");
        jzVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.bofang);
        jzVideoPlayerStandard.setUp(url, jzVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, image);

        jzVideoPlayerStandard.widthRatio = 4;//播放比例
        jzVideoPlayerStandard.heightRatio = 3;
        yxh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yxh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShareUtil.showShare(Hotplay.this,url);
            }
        });


    }

}