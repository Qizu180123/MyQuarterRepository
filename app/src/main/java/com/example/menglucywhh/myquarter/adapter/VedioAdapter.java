package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ASUS on 2018/1/30.
 */

public class VedioAdapter extends RecyclerView.Adapter<VedioAdapter.IViewHolder>{

    private Context context;
    private ArrayList<String> tvlist = new ArrayList<>();

    public VedioAdapter(Context context) {
        this.context = context;
    }

    public void addData(ArrayList<String> tvlist) {
        if (tvlist != null) {
            this.tvlist = tvlist;
        }
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vedio_item, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {

        holder.vedioItemDraweeview.setImageURI(Uri.parse("res://"+context.getPackageName()+"/"+R.drawable.viewpaicolor));
        holder.vedioItemTv.setText(tvlist.get(position));
    }

    @Override
    public int getItemCount() {
        return tvlist.size();
    }


    static class IViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.vedio_item_draweeview)
        SimpleDraweeView vedioItemDraweeview;
        @BindView(R.id.vedio_item_tv)
        TextView vedioItemTv;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
