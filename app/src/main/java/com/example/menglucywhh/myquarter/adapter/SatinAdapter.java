package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(context)
                .load(bean.getData().get(position).getUser().getIcon())
                .transform(new GlideCircleTransform(context)).into(holder.image01);
        holder.text01.setText(bean.getData().get(position).getUser().getNickname());
        holder.text02.setText(list.get(position).getCreateTime());
        holder.text03.setText(list.get(position).getContent());

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
