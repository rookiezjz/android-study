package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class Class1Activity extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView tv_notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class1_layout);
        //设置公告
        tv_notice = (TextView)findViewById(R.id.tv_class1_notice);
        sp = getSharedPreferences("sp_data",MODE_PRIVATE);
        String s = sp.getString("sp_notice","无");
        tv_notice.setText(s);
    }
}