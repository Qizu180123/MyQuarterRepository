package com.example.menglucywhh.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menglucywhh.myquarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/2/3.
 */

public class LocalDirectoryFragment extends Fragment {

    @BindView(R.id.local_one)
    SimpleDraweeView localOne;
    @BindView(R.id.local_two)
    SimpleDraweeView localTwo;
    @BindView(R.id.local_three)
    SimpleDraweeView localThree;
    @BindView(R.id.local_four)
    SimpleDraweeView localFour;
    @BindView(R.id.local_five)
    SimpleDraweeView localFive;
    @BindView(R.id.local_six)
    SimpleDraweeView localSix;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_localdirectory, container, false);
        unbinder = ButterKnife.bind(this, view);

        localOne.setImageResource(R.drawable.huanghun);
        localTwo.setImageResource(R.drawable.login1);
        localThree.setImageResource(R.drawable.write);
        localFour.setImageResource(R.drawable.banner107);
        localFive.setImageResource(R.drawable.banner1033);
        localSix.setImageResource(R.drawable.banner1036);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
