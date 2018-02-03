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
import com.example.menglucywhh.myquarter.adapter.PictureRecyAdapter;
import com.example.menglucywhh.myquarter.adapter.SatinRecyAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //适配器对象
        PictureRecyAdapter satinRecyAdapter = new PictureRecyAdapter(getActivity(), getChildFragmentManager());
        recyclerview.setAdapter(satinRecyAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
