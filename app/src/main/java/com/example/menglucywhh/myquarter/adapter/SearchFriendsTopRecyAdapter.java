package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.MyAttentionBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsTopRecyAdapter extends RecyclerView.Adapter<SearchFriendsTopRecyAdapter.MyViewHolder> {

    List<SearchFriendsTopBean.DataBean> list;
    Context context;
    public SearchFriendsTopRecyAdapter(Context context) {
        this.context = context;
    }


    public void add(List<SearchFriendsTopBean.DataBean> data) {
        if(list==null){
            list = new ArrayList<>();

        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void clear(){
        if (list!=null) {
            list.clear();
            notifyDataSetChanged();
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_searchfriends_toprecy,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(list.size()>0) {

                holder.item_username.setText(list.get(position).getNickname());
                holder.image_cuohao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }else {
                holder.item_username.setText("bilibili哔哩哔哩");
            }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_username;
        private final ImageView image_cuohao;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_username = itemView.findViewById(R.id.item_nickname);
            image_cuohao = itemView.findViewById(R.id.image_cuohao);

        }
    }
}
