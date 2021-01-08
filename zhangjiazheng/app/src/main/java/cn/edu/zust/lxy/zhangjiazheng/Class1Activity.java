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
    }

    @Override
    public void onClick(View v) {
        if(v==tv_message) {
            Intent i = new Intent(this, LeaveWordActivity.class);
            startActivity(i);
        }
    }
}