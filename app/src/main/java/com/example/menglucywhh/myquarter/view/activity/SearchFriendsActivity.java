package com.example.menglucywhh.myquarter.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.SearchFriendsBottomRecyAdapter;
import com.example.menglucywhh.myquarter.adapter.SearchFriendsRecyAdapter;
import com.example.menglucywhh.myquarter.adapter.SearchFriendsTopRecyAdapter;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;
import com.example.menglucywhh.myquarter.presenter.SearchFriendsBottomPresenter;
import com.example.menglucywhh.myquarter.presenter.SearchFriendsPresenter;
import com.example.menglucywhh.myquarter.presenter.SearchFriendsTopPresenter;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsBottomViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsTopViewCallBack;
import com.example.menglucywhh.myquarter.view.callback.SearchFriendsViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchFriendsActivity extends AppCompatActivity implements SearchFriendsViewCallBack,SearchFriendsTopViewCallBack,SearchFriendsBottomViewCallBack{

    @BindView(R.id.history_rela)
    RelativeLayout history_rela;
    @BindView(R.id.search_title)
    RelativeLayout searchtitle;
    @BindView(R.id.search_shuru_linear)
    LinearLayout searchshurulinear;
    @BindView(R.id.search_linear)
    LinearLayout searchlinear;
    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.hotattention_sousuo)
    ImageView hotattentionSousuo;
    @BindView(R.id.searchfriends_shuru)
    EditText searchfriendsShuru;
    @BindView(R.id.searchfriends_quxiao)
    TextView searchfriendsQuxiao;
    @BindView(R.id.top_recy)
    RecyclerView topRecy;
    @BindView(R.id.bottom_recy)
    RecyclerView bottomRecy;
    @BindView(R.id.qingkong_history)
    TextView qingkongHistory;
    @BindView(R.id.sousuo_history)
    TextView souSuoHistory;
    @BindView(R.id.huanyipi)
    TextView huanyipi;
    @BindView(R.id.jiazai)
    ImageView jiazai;
    private SearchFriendsTopPresenter searchFriendsTopPresenter;
    private SearchFriendsBottomPresenter searchFriendsBottomPresenter;

    private SearchFriendsTopRecyAdapter searchFriendsTopRecyAdapter;
    private SearchFriendsBottomRecyAdapter searchFriendsBottomRecyAdapter;
    private SearchFriendsRecyAdapter searchFriendsRecyAdapter;
    private SearchFriendsPresenter searchFriendsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friends);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            searchtitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            searchlinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            topRecy.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            bottomRecy.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            searchshurulinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            history_rela.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));

        }
        //设置输入框光标隐藏
        searchfriendsShuru.setCursorVisible(false);
        searchFriendsTopRecyAdapter = new SearchFriendsTopRecyAdapter(this);
        searchFriendsBottomRecyAdapter = new SearchFriendsBottomRecyAdapter(this);
        searchFriendsRecyAdapter = new SearchFriendsRecyAdapter(this);
        topRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        bottomRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //new出presenter对象
        searchFriendsTopPresenter = new SearchFriendsTopPresenter(this);
        searchFriendsTopPresenter.get();
        //new出presenter对象
        searchFriendsBottomPresenter = new SearchFriendsBottomPresenter(this);
        searchFriendsBottomPresenter.get();
        //new出presenter对象
        searchFriendsPresenter = new SearchFriendsPresenter(this);

    }


    @OnClick({R.id.fanhui,R.id.huanyipi, R.id.hotattention_sousuo,R.id.sousuo_history, R.id.searchfriends_quxiao,R.id.qingkong_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.huanyipi:
                //点击换一批,显示 加载 图片
                jiazai.setVisibility(View.VISIBLE);
                //重新请求 随机钟友
                searchFriendsBottomRecyAdapter.clear();
                searchFriendsBottomPresenter.get();
                break;
            case R.id.sousuo_history:
                //点击搜索历史,展示 搜索钟友 不传参数的
                searchFriendsRecyAdapter.clear();
                searchFriendsTopRecyAdapter.clear();

                searchFriendsTopPresenter.get();
                break;
            case R.id.hotattention_sousuo:
                searchFriendsRecyAdapter.clear();
                if (TextUtils.isEmpty(searchfriendsShuru.getText().toString())) {
                    Toast.makeText(this, "请输入ID或者钟友名", Toast.LENGTH_SHORT).show();
                }else{
                    //根据 钟友名 模糊查询
                    searchFriendsPresenter.get(searchfriendsShuru.getText().toString());
                }
                break;
            case R.id.searchfriends_quxiao:
                //清空edittext
                searchfriendsShuru.setText("");
                searchFriendsRecyAdapter.clear();//点击取消,清空搜索钟友展示的适配器
                break;
            case R.id.qingkong_history:
                searchFriendsTopRecyAdapter.clear();//清空推荐的recy
                searchFriendsRecyAdapter.clear();//清空搜索出来的recy

                break;
        }
    }

    //上面的recy 请求数据成功的回调
    @Override
    public void success(SearchFriendsTopBean searchFriendsTopBean) {
        //System.out.println(searchFriendsTopBean.getData().get(0).getNickname());
        if(searchFriendsTopBean.getData().size()==0) {
            Toast.makeText(this, "暂无搜索历史哦!请搜索", Toast.LENGTH_SHORT).show();
        } else {
            searchFriendsTopRecyAdapter.add(searchFriendsTopBean.getData());
            topRecy.setAdapter(searchFriendsTopRecyAdapter);
        }
    }

    //下面的 recy请求数据的回调
    @Override
    public void success(SearchFriendsBottomBean searchFriendsBottomBean) {
       // System.out.println(searchFriendsBottomBean.getData().get(0).getMobile());
        if(searchFriendsBottomBean.getData().size()==0) {
            Toast.makeText(this, "网有点慢哦!", Toast.LENGTH_SHORT).show();
            jiazai.setVisibility(View.VISIBLE);

        } else {
            searchFriendsBottomRecyAdapter.add(searchFriendsBottomBean.getData());
            bottomRecy.setAdapter(searchFriendsBottomRecyAdapter);
            jiazai.setVisibility(View.GONE);

        }
    }

    //查询 钟友 数据成功的回调
    @Override
    public void success(SearchFriendsBean searchFriendsBean) {
 //查询成功拿到数据
       // System.out.println(searchFriendsBean.getData().get(0).getNickname());
        if(searchFriendsBean.getData().size()==0){
            //如果data集合长度为0,吐司
            Toast.makeText(this, "查询结果不存在", Toast.LENGTH_SHORT).show();

        }else {
            searchFriendsRecyAdapter.add(searchFriendsBean.getData());
            topRecy.setAdapter(searchFriendsRecyAdapter);
        }
    }

    @Override
    public void failure() {
        System.out.println("网慢");
    }
}
