package cn.edu.zust.lxy.zhangjiazheng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.zust.lxy.zhangjiazheng.R;

public class Class2Activity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences sp;
    private TextView tv_notice, tv_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class2_layout);
        //设置公告
        tv_notice = (TextView)findViewById(R.id.tv_class2_notice);
        sp = getSharedPreferences("sp_data",MODE_PRIVATE);
        String s = sp.getString("sp_notice","无");
        tv_notice.setText(s);

        //跳转留言板
        tv_message = (TextView)findViewById(R.id.tv_message_title);
        tv_message.setOnClickListener(this);

        //设置课表
        set_classTable();
    }

    private void set_classTable() {
        TextView class11,class12,class13,class14,
                class21,class22,class23,class24,
                class31,class32,class33,class34,
                class41,class42,class43,class44,
                class51,class52,class53,class54;
        class11 = (TextView)findViewById(R.id.class211); class11.setText(sp.getString("class211","无"));
        class12 = (TextView)findViewById(R.id.class212); class12.setText(sp.getString("class212","无"));
        class13 = (TextView)findViewById(R.id.class213); class13.setText(sp.getString("class213","无"));
        class14 = (TextView)findViewById(R.id.class214); class14.setText(sp.getString("class214","无"));
        class21 = (TextView)findViewById(R.id.class221); class21.setText(sp.getString("class221","无"));
        class22 = (TextView)findViewById(R.id.class222); class22.setText(sp.getString("class222","无"));
        class23 = (TextView)findViewById(R.id.class223); class23.setText(sp.getString("class223","无"));
        class24 = (TextView)findViewById(R.id.class224); class24.setText(sp.getString("class224","无"));
        class31 = (TextView)findViewById(R.id.class231); class31.setText(sp.getString("class231","无"));
        class32 = (TextView)findViewById(R.id.class232); class32.setText(sp.getString("class232","无"));
        class33 = (TextView)findViewById(R.id.class233); class33.setText(sp.getString("class233","无"));
        class34 = (TextView)findViewById(R.id.class234); class34.setText(sp.getString("class234","无"));
        class41 = (TextView)findViewById(R.id.class241); class41.setText(sp.getString("class241","无"));
        class42 = (TextView)findViewById(R.id.class242); class42.setText(sp.getString("class242","无"));
        class43 = (TextView)findViewById(R.id.class243); class43.setText(sp.getString("class243","无"));
        class44 = (TextView)findViewById(R.id.class244); class44.setText(sp.getString("class244","无"));
        class51 = (TextView)findViewById(R.id.class251); class51.setText(sp.getString("class251","无"));
        class52 = (TextView)findViewById(R.id.class252); class52.setText(sp.getString("class252","无"));
        class53 = (TextView)findViewById(R.id.class253); class53.setText(sp.getString("class253","无"));
        class54 = (TextView)findViewById(R.id.class254); class54.setText(sp.getString("class254","无"));
    }

    @Override
    public void onClick(View v) {
        if(v==tv_message) {
            Intent i = new Intent(this, LeaveWordActivity.class);
            startActivity(i);
        }
    }
}