package com.example.menglucywhh.myquarter.view.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.xtablayout.XTabLayout;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.MessagesAdapter;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.fragment.AttentionFragment;
import com.example.menglucywhh.myquarter.view.fragment.HotMenFragment;
import com.example.menglucywhh.myquarter.view.fragment.MessagesFragment;
import com.example.menglucywhh.myquarter.view.fragment.PrivateLetterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessagesActivity extends AppCompatActivity {

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.messages_title)
    RelativeLayout messagesTitle;
    @BindView(R.id.tabLayout)
    TabLayout tablayout;
    @BindView(R.id.qingkong_messages)
    TextView qingkongMessages;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.messages_linear)
    LinearLayout messagesLinear;
    private MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            messagesTitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            messagesLinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
        }
        //设置返回左面的图片
        Drawable drawable_xiangzuo = getResources().getDrawable(R.drawable.xiangzuo);
        drawable_xiangzuo.setBounds(0, 0, 50, 50);//40,40为宽高
        fanhui.setCompoundDrawables(drawable_xiangzuo, null, null, null);

        //设置返回左面的图片
        Drawable drawable_delete = getResources().getDrawable(R.drawable.delete);
        drawable_delete.setBounds(0, 0, 50, 50);//40,40为宽高
        qingkongMessages.setCompoundDrawables(null, null, drawable_delete, null);


        final List<String> list = new ArrayList<>();
        list.add("消息");
        list.add("私信");

        viewPager.setOffscreenPageLimit(list.size());//预加载
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);//和tablayout结合使用
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                if (position == 0) {
                    fragment = new MessagesFragment();//消息的fragment
                } else {
                    fragment = new PrivateLetterFragment();//私信的fragment
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //设置viewpager和Xtablayout联动
        tablayout.setupWithViewPager(viewPager);
    }

    @OnClick({R.id.fanhui, R.id.qingkong_messages})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanhui:
                finish();
                break;
            case R.id.qingkong_messages:
                Toast.makeText(this, "清空消息", Toast.LENGTH_SHORT).show();
                MessagesFragment messagesFragment = new MessagesFragment();
                messagesFragment.recyGone();
                break;
        }
    }
}
