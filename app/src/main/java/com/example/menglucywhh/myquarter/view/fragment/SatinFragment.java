package com.example.menglucywhh.myquarter.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.SatinAdapter;
import com.example.menglucywhh.myquarter.bean.SatinBean;
import com.example.menglucywhh.myquarter.presenter.SatinPresenter;
import com.example.menglucywhh.myquarter.view.IView.SatinView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SatinFragment extends Fragment implements SatinView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;

    public SatinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_satin, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SatinPresenter satinPresenter = new SatinPresenter(this);
        satinPresenter.satin();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(SatinBean bean) {
        SatinAdapter satinAdapter = new SatinAdapter(getActivity());
        satinAdapter.addData(bean);
        satinAdapter.addDatauser(bean);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(satinAdapter);
    }

    @Override
    public void failrue() {

    }
}
