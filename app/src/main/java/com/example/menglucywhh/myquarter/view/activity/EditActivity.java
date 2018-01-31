package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditActivity extends AppCompatActivity {

    @BindView(R.id.edit_back)
    TextView editBack;
    @BindView(R.id.edit_vedio)
    ImageView editVedio;
    @BindView(R.id.edit_talk)
    ImageView editTalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.edit_back, R.id.edit_vedio, R.id.edit_talk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_back:
                finish();
                break;
            case R.id.edit_vedio:
                startActivity(new Intent(this,EditVedioActivity.class));
                break;
            case R.id.edit_talk:
                startActivity(new Intent(this,EditTalkActivity.class));
                break;
        }
    }
}
