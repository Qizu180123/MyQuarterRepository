package com.example.menglucywhh.myquarter.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.CustomViewPager;
import com.example.menglucywhh.myquarter.view.activity.EditActivity;
import com.example.menglucywhh.myquarter.view.activity.MainActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/1/20.
 */

public class VideoFragment extends Fragment {


    @BindView(R.id.touxiang)
    SimpleDraweeView touxiang;
    @BindView(R.id.top_text)
    TextView topText;
    @BindView(R.id.edit)
    ImageView edit;
    @BindView(R.id.aaa)
    RelativeLayout aaa;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.pager)
    CustomViewPager pager;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),EditActivity.class));
            }
        });
        //第一个条目的点击事件
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.touClick();
            }
        });
        final List<String> list = new ArrayList<>();
        list.add("热门");
        list.add("附近");

        pager.setOffscreenPageLimit(list.size());//预加载
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);//和tablayout结合使用
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                if (position == 0) {
                    fragment = new Video_remenFragment();//热门的fragment
                } else {
                    fragment = new Video_remenFragment();//关注的fragment
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //设置viewpager和Xtablayout联动
        xTablayout.setupWithViewPager(pager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
