package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviewShareActivity extends AppCompatActivity {

    @BindView(R.id.previewshare_back)
    TextView previewshareBack;
    @BindView(R.id.imagefuhao)
    ImageView imagefuhao;
    @BindView(R.id.previewshare_bt_fabu)
    Button previewshareBtFabu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_share);
        ButterKnife.bind(this);

        previewshareBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imagefuhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PreviewShareActivity.this,"选择好友",Toast.LENGTH_SHORT).show();
            }
        });

        previewshareBtFabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreviewShareActivity.this, Hotplay.class);
                intent.putExtra("url","http://v7.pstatp.com/778175189f1e48585b2e8ff95ff568e1/5a751ce9/video/m/220746d4352c1ca421381ecf3f49e262c9f1153ed2f000052f8656f756b/");
                intent.putExtra("image","加料不加价");
                startActivity(intent);
                Toast.makeText(PreviewShareActivity.this,"发布分享",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
