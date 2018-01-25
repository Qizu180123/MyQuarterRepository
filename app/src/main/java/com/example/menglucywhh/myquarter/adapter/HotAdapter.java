package com.example.menglucywhh.myquarter.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.HotVideosBean;
import com.example.menglucywhh.myquarter.utils.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by MK on 2018/1/25.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    Context context;

    public HotAdapter(Context context) {
        this.context = context;
    }
    List<HotVideosBean.DataBean> list;
    public void addData(HotVideosBean bean){
        if (list==null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();


    }
    HotVideosBean bean;
    public void addDatauser(HotVideosBean bean){
        this.bean=bean;
    }
    @Override
    public HotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_hotadapter, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HotAdapter.ViewHolder holder, int position) {
        holder.text01.setText(bean.getData().get(position).getUser().getNickname());
        holder.text02.setText(list.get(position).getCreateTime());
        Glide.with(context)
                .load(list.get(position).getCover())
                .transform(new GlideCircleTransform(context)).into(holder.image01);
        holder.videoplayer.setUp(list.get(position).getVideoUrl()
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "嫂子闭眼睛");
        Glide.with(context).load(list.get(position).getCover())
                .into(holder.videoplayer.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_01)
        ImageView image01;
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;
        @BindView(R.id.text_01)
        TextView text01;
        @BindView(R.id.text_02)
        TextView text02;
        @BindView(R.id.text_03)
        TextView text03;
        @BindView(R.id.text_04)
        TextView text04;
        @BindView(R.id.text_05)
        TextView text05;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
