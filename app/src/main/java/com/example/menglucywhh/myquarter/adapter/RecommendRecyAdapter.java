package com.example.menglucywhh.myquarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.ThemeManager;
import com.example.menglucywhh.myquarter.view.activity.EditActivity;
import com.example.menglucywhh.myquarter.view.activity.MainActivity;
import com.example.menglucywhh.myquarter.view.fragment.CenterFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Menglucywhh on 2018/1/22.
 */

public class RecommendRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static Context context;
    FragmentManager childFragmentManager;

    private SlidingMenu menu;
    private TextView takecare;
    private TextView collection;
    private TextView friend;
    private TextView messages;
    private TextView night;
    private TextView myDirectory;
    private TextView settings;
    private static RelativeLayout recommend_title;

    public RecommendRecyAdapter(Context context, FragmentManager childFragmentManager) {
        this.childFragmentManager = childFragmentManager;
        this.context = context;
        EventBus.getDefault().register(this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.item_titletop, null);//第一个布局
            //View view = LayoutInflater.from(context).inflate(R.layout.item_titletop, null);
            parent.addView(view);
            return new OneViewHolder(view);//返回第一个布局
        }
        View view = View.inflate(context, R.layout.item_center, null);//第一个布局

        //View view = LayoutInflater.from(context).inflate(R.layout.item_center,parent,false);
        parent.addView(view);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            //第一个条目的点击事件
           oneViewHolder.touxiang.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
              //
                   MainActivity.touClick();
               }
           });


            oneViewHolder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context,EditActivity.class));

                }
            });

        } else if (holder instanceof IViewHolder) {
            childFragmentManager.beginTransaction().replace(R.id.item_rela, new CenterFragment()).commit();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;//上面的蓝色标题
        }
        return 2;//中间的页面
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public void unregistEventBus(){
        EventBus.getDefault().unregister(this);
    }

  @Subscribe(sticky = true)
  public void eventDayNight(String dayNight){
        if(dayNight.equals("night")){
            recommend_title.setBackgroundColor(context.getResources().getColor(ThemeManager.getCurrentThemeRes(context, R.color.backgroundColor)));
        }else{
            recommend_title.setBackgroundColor(context.getResources().getColor(ThemeManager.getCurrentThemeRes(context, R.color.radio_select)));

        }
  }

    public void setTitleNight(){
      if(recommend_title!=null) {
          recommend_title.setBackgroundColor(context.getResources().getColor(ThemeManager.getCurrentThemeRes(context, R.color.backgroundColor)));
      }
    }
    public void setTitleDay(){
        if(recommend_title!=null) {
            recommend_title.setBackgroundColor(context.getResources().getColor(ThemeManager.getCurrentThemeRes(context, R.color.radio_select)));
        }
    }
    //第一个条目
    public class OneViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView touxiang;
        private final TextView top_text;
        private final ImageView edit;

        public OneViewHolder(View itemView) {
            super(itemView);
            touxiang = itemView.findViewById(R.id.touxiang);
            top_text = itemView.findViewById(R.id.top_text);
            edit = itemView.findViewById(R.id.edit);
            recommend_title = itemView.findViewById(R.id.recommend_title);
        }
    }

    //第二个条目
    public static class IViewHolder extends RecyclerView.ViewHolder {

        public IViewHolder(View itemView) {
            super(itemView);

        }
    }



}
