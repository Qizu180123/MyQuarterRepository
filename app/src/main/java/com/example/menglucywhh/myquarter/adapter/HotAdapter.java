package com.example.menglucywhh.myquarter.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.example.menglucywhh.myquarter.utils.ShareUtil;

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
    public void onBindViewHolder(final HotAdapter.ViewHolder holder, final int position) {
        holder.text01.setText(bean.getData().get(position).getUser().getNickname());
        holder.text02.setText(list.get(position).getCreateTime());
        Glide.with(context)
                .load(list.get(position).getCover())
                .transform(new GlideCircleTransform(context)).into(holder.image01);
        holder.videoplayer.setUp(list.get(position).getVideoUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, "嫂子闭眼睛");
        Glide.with(context).load(list.get(position).getCover())
                .into(holder.videoplayer.thumbImageView);
        holder.image_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtil.showShare(context,list.get(position).getVideoUrl());
            }
        });
        Drawable drawable_pingbi = context.getResources().getDrawable(R.drawable.pingbi);
        drawable_pingbi.setBounds(0, 0, 50, 50);//60,60为宽高
        holder.item_pingbi.setCompoundDrawables(null, drawable_pingbi, null, null);
            Drawable drawable_jubao = context.getResources().getDrawable(R.drawable.jubao);
        drawable_jubao.setBounds(0, 0, 50, 50);//60,60为宽高
        holder.item_jubao.setCompoundDrawables(null, drawable_jubao, null, null);
            Drawable drawable_fuzhilianjie= context.getResources().getDrawable(R.drawable.fuzhilianjie);
        drawable_fuzhilianjie.setBounds(0, 0, 50, 50);//60,60为宽高
        holder.item_fuzhilianjie.setCompoundDrawables(null, drawable_fuzhilianjie, null, null);
        holder.item_gengduo.setTag(1);
            //点击更多按钮 出现的三个按钮
        holder.item_gengduo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int tag = (int) holder.item_gengduo.getTag();
                    if(tag==1){
                        holder.item_gengduo.setTag(2);
                        holder.item_gengduo.setImageResource(R.drawable.gengduo_shouqi);
                        //显示三个按钮
                        holder.item_pingbi.setVisibility(View.VISIBLE);
                        holder.item_jubao.setVisibility(View.VISIBLE);
                        holder.item_fuzhilianjie.setVisibility(View.VISIBLE);

                    }else{
                        holder.item_gengduo.setTag(1);
                        holder.item_gengduo.setImageResource(R.drawable.gengduo);
                        //显示三个按钮
                        holder.item_pingbi.setVisibility(View.INVISIBLE);
                        holder.item_jubao.setVisibility(View.INVISIBLE);
                        holder.item_fuzhilianjie.setVisibility(View.INVISIBLE);
                    }
                }
        });

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
        @BindView(R.id.image_fenxiang)
        ImageView image_fenxiang;
        @BindView(R.id.item_gengduo)
        ImageView item_gengduo;
        @BindView(R.id.item_pingbi)
        TextView item_pingbi;
        @BindView(R.id.item_jubao)
        TextView item_jubao;
        @BindView(R.id.item_fuzhilianjie)
        TextView item_fuzhilianjie;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
