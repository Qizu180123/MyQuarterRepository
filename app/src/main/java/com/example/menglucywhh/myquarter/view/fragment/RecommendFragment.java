package com.example.menglucywhh.myquarter.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.xtablayout.XTabLayout;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.RecommendRecyAdapter;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/1/20.
 */

public class RecommendFragment extends Fragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private RecommendRecyAdapter recommendRecyAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);

        sharedPreferences = getActivity().getSharedPreferences("config", 0);
        edit = sharedPreferences.edit();

        recommendRecyAdapter = new RecommendRecyAdapter(getActivity(), getChildFragmentManager());

        boolean night = sharedPreferences.getBoolean("night", false);
        if(night){
            EventBus.getDefault().postSticky("night");//发送到推荐适配器里
            recommendRecyAdapter.setTitleNight();
        }else{
             EventBus.getDefault().postSticky("day");//发送到推荐适配器里
            recommendRecyAdapter.setTitleDay();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //适配器对象
        recyclerview.setAdapter(recommendRecyAdapter);
    }


    @Override
    public void onResume() {
        super.onResume();
        boolean night = sharedPreferences.getBoolean("night", false);
        if(night){
            EventBus.getDefault().postSticky("night");//发送到推荐适配器里
            recommendRecyAdapter.setTitleNight();
        }else{
            EventBus.getDefault().postSticky("day");//发送到推荐适配器里
            recommendRecyAdapter.setTitleDay();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recommendRecyAdapter.unregistEventBus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
