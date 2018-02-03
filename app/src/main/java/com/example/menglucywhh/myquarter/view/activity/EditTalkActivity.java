package com.example.menglucywhh.myquarter.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menglucywhh.myquarter.R;

public class EditTalkActivity extends AppCompatActivity {

    private EditText etContent;
    private View popupWindow;
    private PopupWindow mPopupWindow;
    private Handler mHandler = new android.os.Handler();
    private TextView talk_publish;
    private TextView talk_back;
    private PopupWindow pw;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_talk);
        etContent = findViewById(R.id.talk_edit);
        talk_publish = findViewById(R.id.talk_publish);
        talk_back = findViewById(R.id.talk_back);
        popupWindow = getLayoutInflater().inflate(R.layout.layout_popwindow, new LinearLayout(this), false);
        mPopupWindow = new PopupWindow(popupWindow, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);

        sharedPreferences=getSharedPreferences("talk.xml",MODE_PRIVATE);
        String talk = sharedPreferences.getString("talk", "");
        if(talk!=null&&!talk.toString().equals("")&&talk.length()>0){
            etContent.setText(talk);
        }else {
            etContent.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View v) {
                    mPopupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
                    mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                    }, 500);
                    mPopupWindow.showAtLocation(EditTalkActivity.this.findViewById(R.id.line), Gravity.BOTTOM, 0, 0);
                }
            });
        }


        talk_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EditTalkActivity.this,TalkShareActivity.class));
                Toast.makeText(EditTalkActivity.this, "发表成功,已分享", Toast.LENGTH_SHORT).show();
            }
        });

        talk_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditPhotoWindow();
            }
        });
    }

    @Override
    public void onBackPressed() {
            showEditPhotoWindow();
    }

    private void showEditPhotoWindow() {

        View contentView = getLayoutInflater().inflate(R.layout.popwindow_layout, null);
        pw = new PopupWindow(contentView, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(), true);
        //设置popupwindow弹出动画
        pw.setAnimationStyle(R.style.popupwindow_anim_style);
        //设置popupwindow背景
        pw.setBackgroundDrawable(new ColorDrawable());
        pw.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);

        //处理popupwindow
        popupwindowselectphoto(contentView);

    }

    //初始化控件和控件的点击事件
    private void popupwindowselectphoto(View contentView) {
        TextView tv_select_pic = (TextView) contentView.findViewById(R.id.tv_photo);
        TextView tv_pai_pic = (TextView) contentView.findViewById(R.id.tv_photograph);
        TextView tv_cancl = (TextView) contentView.findViewById(R.id.tv_cancle);
        LinearLayout layout = (LinearLayout) contentView.findViewById(R.id.dialog_ll);
        tv_select_pic.setOnClickListener(pop);
        tv_pai_pic.setOnClickListener(pop);
        tv_cancl.setOnClickListener(pop);
        layout.setOnClickListener(pop);


    }

    private View.OnClickListener pop = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_photo:
                    String talk=etContent.getText().toString();
                    if(talk!=null&&!talk.toString().equals("")&&talk.length()>0){
                        sharedPreferences.edit().putString("talk",talk).commit();
                        Toast.makeText(EditTalkActivity.this, "保存成功 ", Toast.LENGTH_SHORT).show();
                        pw.dismiss();
                        finish();
                    }else {
                        Toast.makeText(EditTalkActivity.this, "草稿箱内容不能为空!", Toast.LENGTH_SHORT).show();
                        pw.dismiss();
                    }
                    break;
                case R.id.tv_photograph:
                    sharedPreferences.edit().clear().commit();
                    pw.dismiss();
                    finish();
                    break;

                case R.id.tv_cancle:
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;
                //点击提示框以外的地方关闭
                case R.id.dialog_ll:
                    if (pw != null) {
                        pw.dismiss();
                    }
                    break;


            }

        }

    };
}

