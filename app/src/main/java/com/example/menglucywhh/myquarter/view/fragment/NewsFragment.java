package com.example.menglucywhh.myquarter.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.NewsAdapter;
import com.example.menglucywhh.myquarter.utils.ThemeManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/2/3.
 */

public class NewsFragment extends Fragment {

    @BindView(R.id.news_recy)
    RecyclerView newsRecy;
    Unbinder unbinder;
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_attention_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            newsRecy.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(getActivity(), R.color.backgroundColor)));
        }
        newsAdapter = new NewsAdapter(getActivity());
        newsRecy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        newsRecy.setAdapter(newsAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
