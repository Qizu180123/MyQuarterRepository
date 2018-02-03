package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class LoginHomeActivity extends AppCompatActivity {


    @BindView(R.id.my_text_view)
    TextView myTextView;
    @BindView(R.id.my_image_view)
    ImageView myImageView;
    @BindView(R.id.login_wxdl)
    TextView loginWxdl;
    @BindView(R.id.login_wx_onlick)
    RelativeLayout loginWxOnlick;
    @BindView(R.id.login_qqdl)
    TextView loginQqdl;
    @BindView(R.id.login_qq_onlick)
    RelativeLayout loginQqOnlick;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);
        ButterKnife.bind(this);
        imageView = findViewById(R.id.my_image_view);
        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginHomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loginQqdl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(LoginHomeActivity.this, "sssss", Toast.LENGTH_SHORT).show();
                Platform qqlogin = ShareSDK.getPlatform( QQ.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
                qqlogin.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform platform, int action, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        if (action == Platform.ACTION_USER_INFOR) {
                            PlatformDb platDB = platform.getDb();//获取数平台数据DB
                            //通过DB获取各种数据
                            platDB.getToken();
                            platDB.getUserGender();
                            platDB.getUserIcon();
                            platDB.getUserId();
                            platDB.getUserName();
                        }

                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
                qqlogin.authorize();
//                qqlogin.showUser(null);//执行登录，登录后在回调里面获取用户资料
                //weibo.showUser(“3189087725”);//获取账号为“3189087725”的资料
            }
        });


    }
}
