package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.view.activity.MyAttentionActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyAttentionAdapter extends RecyclerView.Adapter<MyAttentionAdapter.MyViewHolder> {

    List<MyAttentionBean.DataBean> list;
    Context context;
    public MyAttentionAdapter(Context context) {
        this.context = context;
    }

    public void add(List<MyAttentionBean.DataBean> data) {
        if(list==null){
            list = new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_myattention,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_username.setText(list.get(position).getUsername());
        holder.item_mobile.setText(list.get(position).getMobile());
        holder.item_time.setText(list.get(position).getCreatetime()+"      ");

        //设置返回左面的图片
        //设置每一行的最右面的 向右的图片
        Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
        drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
        holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_username;
        private final TextView item_mobile;
        private final TextView item_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_username = itemView.findViewById(R.id.item_username);
            item_mobile = itemView.findViewById(R.id.item_mobile);
            item_time = itemView.findViewById(R.id.item_time);

        }
    }
}
