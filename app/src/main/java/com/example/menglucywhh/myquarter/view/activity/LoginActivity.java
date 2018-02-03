package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.Login_Bean;
import com.example.menglucywhh.myquarter.presenter.LoginPresenter;
import com.example.menglucywhh.myquarter.view.IView.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.login_reg)
    TextView loginReg;
    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_back)
    ImageView loginBack;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegActivity.class));
            }
        });
        loginPresenter = new LoginPresenter(this);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.HotVideos(loginUser.getText().toString(), loginPwd.getText().toString());
            }
        });
    }

    @Override
    public void success(Login_Bean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();


    }
}
