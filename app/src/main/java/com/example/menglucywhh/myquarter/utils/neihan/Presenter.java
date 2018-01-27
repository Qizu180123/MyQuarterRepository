package com.example.menglucywhh.myquarter.utils.neihan;

import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;




import com.example.menglucywhh.myquarter.bean.NeihanVideoBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by QinQinBaoBei on 2018/1/25.
 */

public class Presenter {
        Module module = new Module();
        Handler handler = new Handler(Looper.getMainLooper());
     public void getData(final NhPresenterListener nhPresenterListener){
      module.getData(new Module.NhVideoModuleListener() {
          @Override
          public void success(final NeihanVideoBean bean) {
               final List<NeihanVideoBean.DataBeanX.DataBean> list = new ArrayList<>();
               list.clear();
              List<NeihanVideoBean.DataBeanX.DataBean> data = bean.getData().getData();
              for (int i=0;i<data.size();i++){

                  list.add(data.get(i));

              }
              handler.post(new Runnable() {
                  @Override
                  public void run() {

                       if(nhPresenterListener!=null){
                           nhPresenterListener.success(list);
                       }
                  }
              });

          }
      });
    }
    public interface NhPresenterListener{
        void success(List<NeihanVideoBean.DataBeanX.DataBean> list);
    }
}
