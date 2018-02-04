package com.example.menglucywhh.myquarter.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.fragment.AttentionFragment;
import com.example.menglucywhh.myquarter.view.fragment.HotMenFragment;
import com.example.menglucywhh.myquarter.view.fragment.LocalDirectoryFragment;
import com.example.menglucywhh.myquarter.view.fragment.PrivateLetterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DirectoryActivity extends AppCompatActivity {

    @BindView(R.id.directory_linear)
    LinearLayout directorytlinear;
    @BindView(R.id.directory_title)
    RelativeLayout directorytitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fanhui)
    TextView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            directorytlinear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            directorytitle.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            viewPager.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            xTablayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
        }

        //设置返回左面的图片
        Drawable drawable_xiangzuo = getResources().getDrawable(R.drawable.xiangzuo);
        drawable_xiangzuo.setBounds(0, 0, 50, 50);//40,40为宽高
        fanhui.setCompoundDrawables(drawable_xiangzuo, null, null, null);

        final List<String> list = new ArrayList<>();
       list.add("本地作品");
        list.add("已上传");

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
                    fragment = new LocalDirectoryFragment();//热门的fragment
                } else {
                    fragment = new LocalDirectoryFragment();//关注的fragment
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

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
       /* Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);*/
       finish();
    }
}
