package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.Reg_Bean;
import com.example.menglucywhh.myquarter.presenter.RegPresenter;
import com.example.menglucywhh.myquarter.view.IView.RegView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends AppCompatActivity implements RegView{

    @BindView(R.id.reg_back)
    ImageView regBack;
    @BindView(R.id.reg_log)
    TextView regLog;
    @BindView(R.id.reg_user)
    EditText regUser;
    @BindView(R.id.reg_pwd)
    EditText regPwd;
    @BindView(R.id.reg_btn)
    Button regBtn;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        regLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegActivity.this, LoginActivity.class));
                finish();
            }
        });
        regPresenter = new RegPresenter(this);
        //返回
        regBtn.setOnClickListener(new View.OnClickListener() {

            private String pwd;
            private String user;

            @Override
            public void onClick(View v) {
                user = regUser.getText().toString().trim();
                pwd = regPwd.getText().toString().trim();
                Log.e("XXXXXXXXX",user);
                Log.e("XXXXXXXXX",pwd);
                regPresenter.HotVideos(user, pwd);
            }
        });


    }

    @Override
    public void success(Reg_Bean bean) {
        Toast.makeText(this,bean.getMsg(), Toast.LENGTH_SHORT).show();

    }
}
