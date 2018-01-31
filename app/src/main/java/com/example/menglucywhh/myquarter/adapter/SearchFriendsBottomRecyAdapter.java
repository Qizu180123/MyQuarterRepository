package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsTopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsBottomRecyAdapter extends RecyclerView.Adapter<SearchFriendsBottomRecyAdapter.MyViewHolder> {

    List<SearchFriendsBottomBean.DataBean> list;
    Context context;
    public SearchFriendsBottomRecyAdapter(Context context) {
        this.context = context;
    }


    public void add(List<SearchFriendsBottomBean.DataBean> data) {
        if(list==null){
            list = new ArrayList<>();

        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        if (list!=null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_searchfriends_bottomrecy,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(list.size()>0) {
                holder.item_username.setText(list.get(position).getUsername());
                holder.item_mobile.setText(list.get(position).getMobile());
                holder.item_guanzhu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "点击加关注" + list.get(position).getUsername(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                holder.item_username.setText("风景油画技术在手跟我走");
                holder.item_mobile.setText("喜欢风景,喜欢油画更喜欢音乐");
            }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_mobile;
        private final TextView item_username;
        private final TextView item_guanzhu;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_username = itemView.findViewById(R.id.item_username);
            item_mobile = itemView.findViewById(R.id.item_mobile);
            item_guanzhu = itemView.findViewById(R.id.item_guanzhu);

        }
    }
}
