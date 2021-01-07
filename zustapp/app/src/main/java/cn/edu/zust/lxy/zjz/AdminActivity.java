
package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_userInfo, btn_class1, btn_class2, btn_notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);

        btn_userInfo = (Button)findViewById(R.id.btn_admin_userinfo);
        btn_class1 = (Button)findViewById(R.id.btn_admin_class1);
        btn_class2 = (Button)findViewById(R.id.btn_admin_class2);
        btn_notice = (Button)findViewById(R.id.btn_admin_notice);

        btn_notice.setOnClickListener(this);
        btn_userInfo.setOnClickListener(this);
        btn_class1.setOnClickListener(this);
        btn_class2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btn_admin_userinfo:{
                i = new Intent(this, ShowUserInfoActivity.class);
                break;
            }
            default: {
            }
        }
        startActivity(i);
    }
}