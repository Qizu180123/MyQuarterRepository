package com.example.menglucywhh.myquarter.view.fragment;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       /* final List<String> list = new ArrayList<>();
        list.add("热门");
        list.add("关注");

        viewPager.setOffscreenPageLimit(list.size());//预加载
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);//和tablayout结合使用
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                if (position == 0) {
                    fragment = new HotMenFragment();//热门的fragment
                } else {
                    fragment = new AttentionFragment();//关注的fragment
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //设置viewpager和Xtablayout联动
        xTablayout.setupWithViewPager(viewPager);*/
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //适配器对象
        RecommendRecyAdapter recommendRecyAdapter = new RecommendRecyAdapter(getActivity(), getChildFragmentManager());
        recyclerview.setAdapter(recommendRecyAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
