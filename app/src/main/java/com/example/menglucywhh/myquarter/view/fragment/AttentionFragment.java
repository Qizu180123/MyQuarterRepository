package com.example.menglucywhh.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.HotAdapter;
import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.presenter.HotVideosPresenter;
import com.example.menglucywhh.myquarter.view.IView.HotVideosView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Menglucywhh on 2018/1/20.
 */

public class AttentionFragment extends Fragment implements HotVideosView {

    @BindView(R.id.image_01)
    ImageView image01;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    private HotAdapter hotAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //热门recy
        HotVideosPresenter hotVideosPresenter = new HotVideosPresenter(this);
        hotVideosPresenter.HotVideos();
        recyclerview.setFocusable(false);
        hotAdapter = new HotAdapter(getActivity());
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(hotAdapter);

    }

    @Override
    public void success(HotVideosBean bean) {
        hotAdapter.addData(bean);
        hotAdapter.addDatauser(bean);
    }

    @Override
    public void failrue() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
