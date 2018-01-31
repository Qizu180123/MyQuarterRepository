package com.example.menglucywhh.myquarter.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.xtablayout.XTabLayout;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.fragment.AttentionFragment;
import com.example.menglucywhh.myquarter.view.fragment.HotMenFragment;
import com.example.menglucywhh.myquarter.view.fragment.PrivateLetterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotAttentionActivity extends AppCompatActivity {

    @BindView(R.id.hotattention_linear)
    LinearLayout hotattentionlinear;
    @BindView(R.id.hotattention_shurulinear)
    LinearLayout hotattentionshurulinear;
    @BindView(R.id.hotattention_title)
    RelativeLayout hotattentiontitle;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.hotattention_shuru)
    EditText hotattentionShuru;
    @BindView(R.id.hotattention_sousuo)
    ImageView hotattentionSousuo;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_attention);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            hotattentionlinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            hotattentionshurulinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            hotattentiontitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            xTablayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
        }

        //输入框 隐藏光标
        hotattentionShuru.setCursorVisible(false);

        final List<String> list = new ArrayList<>();
        list.add("新闻");
        list.add("爆笑");
        list.add("励志");
        list.add("美食");
        list.add("网红");
        list.add("颜值");
        viewPager.setOffscreenPageLimit(list.size());//预加载
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);//和tablayout结合使用
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;

                switch (position){
                    case 0:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                    case 1:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                    case 2:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                    case 3:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                    case 4:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                    case 5:
                        fragment = new PrivateLetterFragment();//热门的fragment
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //设置viewpager和Xtablayout联动
        xTablayout.setupWithViewPager(viewPager);

    }

    @OnClick({R.id.quxiao, R.id.hotattention_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quxiao:
                finish();
                break;
            case R.id.hotattention_sousuo:
                if (TextUtils.isEmpty(hotattentionShuru.getText().toString())) {
                    Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
                } else {
                    //如果输入框不为空.就查询

                }
                break;
        }
    }
}
