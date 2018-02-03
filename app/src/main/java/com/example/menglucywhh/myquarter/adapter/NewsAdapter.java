package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Menglucywhh on 2018/1/29.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    int type = 1;
    Context context;
    public NewsAdapter(Context context){
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==1){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }else if (viewType==2){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }else if (viewType==3){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }else if (viewType==4){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }else if (viewType==5){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }else if (viewType==6){
            View view = View.inflate(context, R.layout.item_hotattention_news,null);
            return new MyViewHolder(view);
        }
        View view = View.inflate(context, R.layout.item_hotattention_news,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (position==0) {
            holder.item_touxiang.setImageURI("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1604572056,73487110&fm=27&gp=0.jpg");
            holder.item_username.setText("柯诺马斯基");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-07-05  11 : 52      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }else if (position==1) {
            holder.item_touxiang.setImageURI("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=12867320,655225767&fm=27&gp=0.jpg");
            holder.item_username.setText("米其林轮胎");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-07-06  10 : 52      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }else if (position==2) {
            holder.item_touxiang.setImageURI("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=817314671,64978970&fm=27&gp=0.jpg");
            holder.item_username.setText("多米辣条工厂");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-07-07  11 : 33      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }else if (position==3) {
            holder.item_touxiang.setImageURI("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2334584121,1324775889&fm=27&gp=0.jpg");
            holder.item_username.setText("芒果王子");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-06-05  10 : 54      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }else if (position==4) {
            holder.item_touxiang.setImageURI("http://img5.imgtn.bdimg.com/it/u=1922355689,2789722564&fm=27&gp=0.jpg");
            holder.item_username.setText("曹小花甜品店");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-05-05  09 : 52      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }else if (position==5) {
            holder.item_touxiang.setImageURI("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1116587413,1335069674&fm=27&gp=0.jpg");
            holder.item_username.setText("王大头烤肉");
            holder.item_mobile.setText("吃货们快戳我 ~ !");
            holder.item_time.setText("2017-07-05  11 : 52      ");
            //设置每一行的最右面的 向右的图片
            Drawable drawable_sliding_xiangyoua = context.getResources().getDrawable(R.drawable.sliding_xiangyouhui);
            drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
            holder.item_time.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                type=1;
                break;
            case 1:
                type=2;
                break;
            case 2:
                type=3;
                break;
            case 3:
                type=4;
                break;
            case 4:
                type=5;
                break;
            case 5:
                type=6;
                break;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView item_touxiang;
        private final TextView item_username;
        private final TextView item_mobile;
        private final TextView item_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_touxiang = itemView.findViewById(R.id.touxiang);
            item_username = itemView.findViewById(R.id.item_username);
            item_mobile = itemView.findViewById(R.id.item_mobile);
            item_time = itemView.findViewById(R.id.item_time);

        }
    }
}
