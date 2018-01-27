package com.example.menglucywhh.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.menglucywhh.myquarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/1/20.
 */

public class VideoFragment extends Fragment {

    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.news)
    RadioButton news;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.pager)
    ViewPager pager;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup radioGroup, int i) {//fragment滑动
                switch (i){
                    case R.id.mine:
                        pager.setCurrentItem(0,false);
                        break;
                    case R.id.news:
                        pager.setCurrentItem(1,false);
                        break;

                }
            }
        });
//        tablayout.setupWithViewPager(viewPager);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {//viewpager点击

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }


            public void onPageScrollStateChanged(int state) {

            }
        });
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment=new Video_remenFragment();
                        break;
                    case 1:fragment=new Video_fujinFragment();
                        break;

                }
                return fragment;
            }


            public int getCount() {
                return 2;
            }
        });
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
