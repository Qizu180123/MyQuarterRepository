package com.example.menglucywhh.myquarter.view.activity;

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
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.MyCollectionRecyAdapter;
import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.presenter.MyCollectionPresenter;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.callback.MyCollectionViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyCollectionActivity extends AppCompatActivity implements MyCollectionViewCallBack{

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.mycollection_delete)
    TextView mycollectionDelete;
    @BindView(R.id.mycollection_title)
    RelativeLayout mycollectionTitle;
    @BindView(R.id.mycollection_linear)
    LinearLayout mycollection_linear;
    @BindView(R.id.mycollection_recy)
    RecyclerView mycollectionRecy;
    private MyCollectionPresenter myCollectionPresenter;
    private MyCollectionRecyAdapter myCollectionRecyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            mycollectionTitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            mycollection_linear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
        }

        //设置返回左面的图片
        Drawable drawable_xiangzuo = getResources().getDrawable(R.drawable.xiangzuo);
        drawable_xiangzuo.setBounds(0, 0, 50, 50);//40,40为宽高
        fanhui.setCompoundDrawables(drawable_xiangzuo, null, null, null);

        mycollectionRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        myCollectionPresenter = new MyCollectionPresenter(this);
        myCollectionRecyAdapter = new MyCollectionRecyAdapter(this);
        myCollectionPresenter.get();
    }

    @OnClick({R.id.fanhui, R.id.mycollection_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.mycollection_delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                 myCollectionRecyAdapter.setGouXuanVisable();
                break;
        }
    }

    @Override
    public void success(MyCollectionBean myCollectionBean) {
    if (myCollectionBean!=null){
        System.out.println(myCollectionBean.getData().get(0).getUid());
        myCollectionRecyAdapter.add(myCollectionBean.getData());
        mycollectionRecy.setAdapter(myCollectionRecyAdapter);
    }
    }

    @Override
    public void failure() {
        System.out.println("MyCollection网慢");
    }


}
