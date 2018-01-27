package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.bean.SatinBean;
import com.example.menglucywhh.myquarter.utils.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MK on 2018/1/25.
 */

public class SatinAdapter extends RecyclerView.Adapter<SatinAdapter.ViewHolder> {
    Context context;

    public SatinAdapter(Context context) {
        this.context = context;
    }

    List<SatinBean.DataBean> list;

    public void addData(SatinBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();


    }

    SatinBean bean;

    public void addDatauser(SatinBean bean) {
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_satinadapter, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(bean.getData().get(position).getUser().getIcon())
                .transform(new GlideCircleTransform(context)).into(holder.image01);
        holder.text01.setText(bean.getData().get(position).getUser().getNickname());
        holder.text02.setText(list.get(position).getCreateTime());
        holder.text03.setText(list.get(position).getContent());



    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_01)
        ImageView image01;
        @BindView(R.id.text_01)
        TextView text01;
        @BindView(R.id.text_02)
        TextView text02;
        @BindView(R.id.text_03)
        TextView text03;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
