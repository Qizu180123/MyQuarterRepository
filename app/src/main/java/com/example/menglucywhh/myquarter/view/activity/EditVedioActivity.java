package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.VedioAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class EditVedioActivity extends AppCompatActivity {

    private SimpleDraweeView vediogif;
    private TextView talk_back;
    private ArrayList<String> tvlist;
    private RecyclerView vedio_recycle;
    private ImageView paizhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vedio);
        vedio_recycle = findViewById(R.id.vedio_recycle);
        paizhao = findViewById(R.id.paizhao);

        setData();

        talk_back = findViewById(R.id.talk_back);

        paizhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditVedioActivity.this,PreviewActivity.class));
            }
        });

        talk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        vediogif = findViewById(R.id.vediogif);


               DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res://"+getPackageName()+"/"+R.drawable.vedioone))
                .setAutoPlayAnimations(true)//设置为true将循环播放Gif动画
                .setOldController(vediogif.getController())
                .build();

        // 设置控制器
        vediogif.setController(controller);


        Animatable animation = vediogif.getController().getAnimatable();

        if (animation != null && !animation.isRunning()) {
            animation.start();
        }

    }

    private void setData() {
        tvlist=new ArrayList<>();
        tvlist.add("原画");
        tvlist.add("唯美");
        tvlist.add("复古");
        tvlist.add("阿宝色");
        tvlist.add("温暖");
        tvlist.add("清纯");
        tvlist.add("日系");
        tvlist.add("黑白");

        VedioAdapter vedioAdapter = new VedioAdapter(this);
        vedioAdapter.addData(tvlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        vedio_recycle.setLayoutManager(linearLayoutManager);
        vedio_recycle.setAdapter(vedioAdapter);

    }
}
