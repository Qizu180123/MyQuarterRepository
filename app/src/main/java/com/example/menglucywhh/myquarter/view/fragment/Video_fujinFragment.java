package com.example.menglucywhh.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.RemenAdapter;
import com.example.menglucywhh.myquarter.bean.shipingBean;
import com.example.menglucywhh.myquarter.presenter.AddPresenter;
import com.example.menglucywhh.myquarter.view.AddView;


/**
 * Created by fuck on 2018/1/22.
 */

public class Video_fujinFragment extends Fragment implements AddView {

    private AddPresenter presenter;
    private RecyclerView recycle_fujin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fujin, container, false);
        presenter = new AddPresenter(this);
        presenter.shangpin();
        recycle_fujin = view.findViewById(R.id.recycle_fujin);
        return  view;
    }

    @Override
    public void success(shipingBean shipingBean) {
        RemenAdapter adapter = new RemenAdapter(getActivity());
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycle_fujin.setLayoutManager(recyclerViewLayoutManager);
        recycle_fujin.setAdapter(adapter);
    }

    @Override
    public void failrue() {

    }
}
