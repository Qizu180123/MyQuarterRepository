package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.MyAttentionAdapter;
import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.presenter.MyAttentionPresenter;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.callback.MyAttentionViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAttentionActivity extends AppCompatActivity implements MyAttentionViewCallBack {

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.remen_linear)
    LinearLayout remenlinear;

    @BindView(R.id.remen_title)
    RelativeLayout rementitle;
    @BindView(R.id.myattention_recyclerview)
    RecyclerView myattentionRecyclerview;
    @BindView(R.id.remen_guanzhu)
    TextView remenGuanzhu;
    private MyAttentionPresenter myAttentionPresenter;
    private MyAttentionAdapter myAttentionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attention);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            rementitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            myattentionRecyclerview.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            remenlinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
        }

        //设置返回左面的图片
        Drawable drawable_xiangzuo = getResources().getDrawable(R.drawable.xiangzuo);
        drawable_xiangzuo.setBounds(0, 0, 50, 50);//40,40为宽高
        fanhui.setCompoundDrawables(drawable_xiangzuo, null, null, null);

        myAttentionAdapter = new MyAttentionAdapter(this);
        //设置垂直布局
        myattentionRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //mvp
        myAttentionPresenter = new MyAttentionPresenter(this);
        myAttentionPresenter.get();

    }
    @OnClick({R.id.fanhui, R.id.remen_guanzhu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.remen_guanzhu:
                Intent intent = new Intent(this, HotAttentionActivity.class);
                startActivity(intent);
                break;
        }
    }

    //成功的回调
    @Override
    public void success(MyAttentionBean myAttentionBean) {
        //拿到了成功的数据,传给适配器展示
        if (myAttentionBean != null) {
            System.out.println(myAttentionBean.getData().get(0).getUsername());
            myAttentionAdapter.add(myAttentionBean.getData());
            myattentionRecyclerview.setAdapter(myAttentionAdapter);

        }
    }

    @Override
    public void failure() {
        System.out.println("MyAttention网慢");

    }


}
