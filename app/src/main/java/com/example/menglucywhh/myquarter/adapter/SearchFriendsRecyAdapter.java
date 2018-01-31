package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class SearchFriendsRecyAdapter extends RecyclerView.Adapter<SearchFriendsRecyAdapter.MyViewHolder> {

    List<SearchFriendsBean.DataBean> list;
    Context context;
    public SearchFriendsRecyAdapter(Context context) {
        this.context = context;
    }


    public void add(List<SearchFriendsBean.DataBean> data) {
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
        View view = View.inflate(context, R.layout.item_searchfriends_bottomrecy,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(list.size()>0) {
                holder.item_username.setText(list.get(position).getNickname());
                holder.item_mobile.setText(list.get(position).getMobile());
                holder.item_guanzhu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "关注钟友:" + list.get(position).getNickname(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{

                Toast.makeText(context, "查询内容不存在", Toast.LENGTH_SHORT).show();
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
