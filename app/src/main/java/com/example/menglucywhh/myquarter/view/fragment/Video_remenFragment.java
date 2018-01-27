package com.example.menglucywhh.myquarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.adapter.RemenAdapter;
import com.example.menglucywhh.myquarter.bean.NeihanVideoBean;
import com.example.menglucywhh.myquarter.bean.shipingBean;
import com.example.menglucywhh.myquarter.utils.neihan.Presenter;
import com.example.menglucywhh.myquarter.view.AddView;


import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fuck on 2018/1/22.
 */

public class Video_remenFragment extends Fragment implements AddView {
    @BindView(R.id.recycle_remen)
    RecyclerView recycleRemen;
    Unbinder unbinder;
    private RemenAdapter adapter;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remen, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new Presenter();
        presenter.getData(new Presenter.NhPresenterListener() {
            @Override
            public void success(List<NeihanVideoBean.DataBeanX.DataBean> list) {
                adapter = new RemenAdapter(getActivity(),list);

                StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recycleRemen.setLayoutManager(recyclerViewLayoutManager);
                recycleRemen.setAdapter(adapter);
            }
        });
        Log.i("1111111111",view.toString());
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        try {
            Field childFragmentManager = Fragment.class
                    .getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void success(shipingBean shipingBean) {


    }
    @Override
    public void failrue() {

    }
}
