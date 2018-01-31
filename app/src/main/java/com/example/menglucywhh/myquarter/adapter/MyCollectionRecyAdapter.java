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
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.bean.MyCollectionBean;
import com.example.menglucywhh.myquarter.bean.SearchFriendsBottomBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Menglucywhh on 2018/1/25.
 */

public class MyCollectionRecyAdapter extends RecyclerView.Adapter<MyCollectionRecyAdapter.MyViewHolder> {

    List<MyCollectionBean.DataBean> list;
    Context context;
    private static ImageView item_gouxuan;

    public MyCollectionRecyAdapter(Context context) {
        this.context = context;
    }

    public void add(List<MyCollectionBean.DataBean> data) {
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
        View view = View.inflate(context, R.layout.item_mycollection_recy,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if(list.size()>0) {

                holder.touxiang.setImageURI(list.get(position).getUser().getIcon());
                holder.item_nickname.setText(list.get(position).getUser().getNickname());
                holder.item_time.setText(list.get(position).getCreateTime());
                holder.item_gengduo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "更多选项", Toast.LENGTH_SHORT).show();
                    }
                });
            String videoUrl = list.get(position).getVideoUrl();
           String url ="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
            holder.item_text.setText(list.get(position).getWorkDesc());


            //节操播放器
            String jcvideoUrl ="http://ssb-video.oss-cn-qingdao.aliyuncs.com/Video_1003_20161027140007.mp4";
            JCVideoPlayerStandard.TOOL_BAR_EXIST = false;
            holder.jcVideoPlayerStandard.setUp(videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
            //holder.jcVideoPlayerStandard.loop  = true;//是否循环播放
            Glide.with(context.getApplicationContext()).load(list.get(position).getUser().getIcon())
                    .into(holder.jcVideoPlayerStandard.thumbImageView);
            holder.jcVideoPlayerStandard.widthRatio = 4;//播放比例
            holder.jcVideoPlayerStandard.heightRatio = 3;

//        JCVideoPlayerStandard.startFullscreen(this, JCVideoPlayerStandard.class, "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", "嫂子辛苦了");
            //直接进入全屏

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

           item_gouxuan.setTag(1);
           item_gouxuan.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                  int tag = (int) item_gouxuan.getTag();
                  if(tag==1){
                      item_gouxuan.setTag(2);
                      item_gouxuan.setImageResource(R.drawable.yigouxuan);
                  }else{
                      item_gouxuan.setTag(1);
                      item_gouxuan.setImageResource(R.drawable.weigouxuan);
                  }
               }
           });
        }else{
                holder.item_nickname.setText("风景油画技术在手跟我走");
            }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_text;
        private final TextView item_time;
        private final TextView item_nickname;
        private final ImageView item_gengduo;
        private final SimpleDraweeView touxiang;
        private final TextView item_pingbi;
        private final TextView item_jubao;
        private final TextView item_fuzhilianjie;
        private final JCVideoPlayerStandard jcVideoPlayerStandard;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_nickname = itemView.findViewById(R.id.item_nickname);
            item_time = itemView.findViewById(R.id.item_time);
            item_gengduo = itemView.findViewById(R.id.item_gengduo);
            item_text = itemView.findViewById(R.id.item_text);
            touxiang = itemView.findViewById(R.id.touxiang);
            item_gouxuan = itemView.findViewById(R.id.item_gouxuan);
            //节操
            jcVideoPlayerStandard = itemView.findViewById(R.id.jcvideoplayer);

            item_pingbi = itemView.findViewById(R.id.item_pingbi);
            item_jubao = itemView.findViewById(R.id.item_jubao);
            item_fuzhilianjie = itemView.findViewById(R.id.item_fuzhilianjie);
        }

    }

    public void setGouXuanVisable(){
        if (item_gouxuan!=null) {
            item_gouxuan.setVisibility(View.VISIBLE);
        }
    }

}

