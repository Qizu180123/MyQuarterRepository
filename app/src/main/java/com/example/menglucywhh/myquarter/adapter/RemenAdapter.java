package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;

import com.example.menglucywhh.myquarter.bean.NeihanVideoBean;
import com.example.menglucywhh.myquarter.view.activity.Hotplay;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fuck on 2018/1/22.
 */
public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.IViewHolder> {
    Context context;

    private List<Integer> heightList = new ArrayList<>();//装产出的随机数
    private OnRecyclerItemClickListener mOnItemClickListener;//单击事件
    private onRecyclerItemLongClickListener mOnItemLongClickListener;//长按事件
    private String value;

    private OnItemClickListener mOnItemClickListener1 = null;
    List<NeihanVideoBean.DataBeanX.DataBean> list;
    public RemenAdapter(Context context, List<NeihanVideoBean.DataBeanX.DataBean> list) {
     this.context=context;
     this.list=list;

    }

    public RemenAdapter(Context context) {
        this.context=context;
    }

    //最后暴露给外面的调用者，定义一个设置Listener的方法（）：
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener1 = listener;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.remen_item, null);
        return new IViewHolder(view,mOnItemClickListener1);
    }

    @Override
    public void onBindViewHolder(final IViewHolder holder, final int position) {
        addItem(position);
        holder.image.setImageURI(list.get(position).getGroup().getLarge_cover().getUrl_list().get(0).getUrl());
        ViewGroup.LayoutParams params = holder.image.getLayoutParams();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Hotplay.class);
                intent.putExtra("url",list.get(position).getGroup().getMp4_url());
                intent.putExtra("image",list.get(position).getGroup().getText());
                context.startActivity(intent);
            }
        });

        params.height = heightList.get(position);
        holder.image.setLayoutParams(params);
        if (mOnItemClickListener != null) {
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onItemClick(v, position);
                    mOnItemClickListener.onItemClick(v, holder.getLayoutPosition());
                }
            });
        }

        if (mOnItemLongClickListener != null) {
            holder.image.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    mOnItemLongClickListener.onItemLongClick(v, holder.getLayoutPosition());
                    return true;
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }



    static class IViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private SimpleDraweeView image;
        private OnItemClickListener mOnItemClickListener1 = null;
        IViewHolder(View view,OnItemClickListener mClickListener) {
            super(view);
            this.mOnItemClickListener1=mClickListener;
            image = view.findViewById(R.id.sdv);
        }
        public void onClick(View view) {
            mOnItemClickListener1.onItemClick(view,getPosition(),(String) view.getTag());
        }
    }

    interface OnRecyclerItemClickListener {
        public void onItemClick(View view, int position);
    }

    /**
     * 长按事件
     */
    interface onRecyclerItemLongClickListener {
        public void onItemLongClick(View view, int position);
    }

    /**
     * 暴露给外面的设置单击事件
     */
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * 暴露给外面的长按事件
     */
    public void setOnItemLongClickListener(onRecyclerItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 向指定位置添加元素
     */
    public void addItem(int position) {
        if (position > list.size()) {
            position = list.size();
        }
        if (position < 0) {
            position = 0;
        }         /**          * 使用notifyItemInserted/notifyItemRemoved会有动画效果          * 而使用notifyDataSetChanged()则没有          */
        heightList.add(position, new Random().nextInt(200) + 100);//添加一个随机高度,会在onBindViewHolder方法中得到设置         notifyItemInserted(position);//通知插入了数据     }      /**      * 移除指定位置元素      */     public String removeItem(int position) {         if(position > list.size()-1) {             return null;         }         heightList.remove(position);//删除添加的高度         //所以还需要手动在集合中删除一次         value = String.valueOf(list.remove(position));         notifyItemRemoved(position);//通知删除了数据,但是没有删除list集合中的数据         return value;     } }xxh
    }
    public static interface OnItemClickListener {
        void onItemClick(View view, int position, String page);

        void onItemClick(View itemView, int position);
    }
}