package com.example.menglucywhh.myquarter.view.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.menglucywhh.myquarter.R;
import com.example.menglucywhh.myquarter.utils.ThemeManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.settings_linear)
    LinearLayout settings_linear;
    @BindView(R.id.settings_title)
    RelativeLayout settings_title;
    @BindView(R.id.settings_jianchaline)
    RelativeLayout settings_jianchaline;
    @BindView(R.id.settings_yijianline)
    RelativeLayout settings_yijianline;
    @BindView(R.id.settings_guanyuline)
    RelativeLayout settings_guanyuline;
    @BindView(R.id.settings_qingchuline)
    RelativeLayout settings_qingchuline;
    @BindView(R.id.settings_tuichubutton)
    Button settings_tuichubutton;

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.jiancha_gengxin)
    TextView jianchaGengxin;
    @BindView(R.id.jiancha_right)
    TextView jianchaRight;
    @BindView(R.id.yijian_fankui)
    TextView yijianFankui;
    @BindView(R.id.yijian_right)
    TextView yijianRight;
    @BindView(R.id.guanyu_yikezhong)
    TextView guanyuYikezhong;
    @BindView(R.id.guanyu_right)
    TextView guanyuRight;
    @BindView(R.id.qingchu_huancun)
    TextView qingchuHuancun;
    @BindView(R.id.qingchu_right)
    TextView qingchuRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        //进入页面取值,判断是否夜间
        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        boolean night = sharedPreferences.getBoolean("night",false);
        if(night){
            settings_linear.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_title.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_jianchaline.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_yijianline.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_guanyuline.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_qingchuline.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));
            settings_tuichubutton.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(this, R.color.backgroundColor)));

        }
        //设置返回左面的图片
        Drawable drawable_xiangzuo = getResources().getDrawable(R.drawable.xiangzuo);
        drawable_xiangzuo.setBounds(0, 0, 50, 50);//40,40为宽高
        fanhui.setCompoundDrawables(drawable_xiangzuo, null, null, null);

        //设置每一行的最右面的 向右的图片
        Drawable drawable_sliding_xiangyoua = getResources().getDrawable(R.drawable.sliding_xiangyouhui);
        drawable_sliding_xiangyoua.setBounds(0, 0, 33, 33);//40,40为宽高
        //检查更新的右面
        jianchaRight.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        yijianRight.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        guanyuRight.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);
        qingchuRight.setCompoundDrawables(null, null, drawable_sliding_xiangyoua, null);

    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }
}
