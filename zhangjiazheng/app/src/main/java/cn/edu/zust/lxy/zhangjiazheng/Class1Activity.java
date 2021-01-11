package cn.edu.zust.lxy.zhangjiazheng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.zust.lxy.zhangjiazheng.R;

public class Class1Activity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences sp;
    private TextView tv_notice, tv_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class1_layout);
        //设置公告
        tv_notice = (TextView)findViewById(R.id.tv_class1_notice);
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
        class11 = (TextView)findViewById(R.id.class111); class11.setText(sp.getString("class111","无"));
        class12 = (TextView)findViewById(R.id.class112); class12.setText(sp.getString("class112","无"));
        class13 = (TextView)findViewById(R.id.class113); class13.setText(sp.getString("class113","无"));
        class14 = (TextView)findViewById(R.id.class114); class14.setText(sp.getString("class114","无"));
        class21 = (TextView)findViewById(R.id.class121); class21.setText(sp.getString("class121","无"));
        class22 = (TextView)findViewById(R.id.class122); class22.setText(sp.getString("class122","无"));
        class23 = (TextView)findViewById(R.id.class123); class23.setText(sp.getString("class123","无"));
        class24 = (TextView)findViewById(R.id.class124); class24.setText(sp.getString("class124","无"));
        class31 = (TextView)findViewById(R.id.class131); class31.setText(sp.getString("class131","无"));
        class32 = (TextView)findViewById(R.id.class132); class32.setText(sp.getString("class132","无"));
        class33 = (TextView)findViewById(R.id.class133); class33.setText(sp.getString("class133","无"));
        class34 = (TextView)findViewById(R.id.class134); class34.setText(sp.getString("class134","无"));
        class41 = (TextView)findViewById(R.id.class141); class41.setText(sp.getString("class141","无"));
        class42 = (TextView)findViewById(R.id.class142); class42.setText(sp.getString("class142","无"));
        class43 = (TextView)findViewById(R.id.class143); class43.setText(sp.getString("class143","无"));
        class44 = (TextView)findViewById(R.id.class144); class44.setText(sp.getString("class144","无"));
        class51 = (TextView)findViewById(R.id.class151); class51.setText(sp.getString("class151","无"));
        class52 = (TextView)findViewById(R.id.class152); class52.setText(sp.getString("class152","无"));
        class53 = (TextView)findViewById(R.id.class153); class53.setText(sp.getString("class153","无"));
        class54 = (TextView)findViewById(R.id.class154); class54.setText(sp.getString("class154","无"));
    }
    @Override
    public void onClick(View v) {
        if(v==tv_message) {
            Intent i = new Intent(this, LeaveWordActivity.class);
            startActivity(i);
        }
    }
}