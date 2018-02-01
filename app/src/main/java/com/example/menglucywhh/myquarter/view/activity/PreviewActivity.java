package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.VedioAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewActivity extends AppCompatActivity {

    @BindView(R.id.previewgif)
    SimpleDraweeView previewgif;
    @BindView(R.id.preview_back)
    TextView previewBack;
    @BindView(R.id.preview_recycle)
    RecyclerView previewRecycle;
    @BindView(R.id.preview_bt_next)
    Button previewBtNext;
    @BindView(R.id.preview_save)
    TextView previewSave;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        setData();

        previewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PreviewActivity.this,DirectoryActivity.class));
                finish();
            }
        });

        previewBtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PreviewActivity.this,PreviewShareActivity.class));
            }
        });

        previewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("res://" + getPackageName() + "/" + R.drawable.previewgif))
                .setAutoPlayAnimations(true)//设置为true将循环播放Gif动画
                .setOldController(previewgif.getController())
                .build();

        // 设置控制器
        previewgif.setController(controller);


        Animatable animation = previewgif.getController().getAnimatable();

        if (animation != null && !animation.isRunning()) {
            animation.start();
        }
    }

    private void setData() {
        list = new ArrayList<>();
        list.add("原画");
        list.add("柔光");
        list.add("复古");
        list.add("黑白");

        VedioAdapter vedioAdapter = new VedioAdapter(this);
        vedioAdapter.addData(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        previewRecycle.setLayoutManager(linearLayoutManager);
        previewRecycle.setAdapter(vedioAdapter);
    }
}
