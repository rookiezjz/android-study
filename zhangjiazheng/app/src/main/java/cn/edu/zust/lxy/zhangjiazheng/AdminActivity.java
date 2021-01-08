
package cn.edu.zust.lxy.zhangjiazheng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.zust.lxy.zhangjiazheng.R;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_userInfo, btn_class1, btn_class2, btn_notice, btn_quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);

        btn_userInfo = (Button)findViewById(R.id.btn_admin_userinfo);
        btn_class1 = (Button)findViewById(R.id.btn_admin_class1);
        btn_class2 = (Button)findViewById(R.id.btn_admin_class2);
        btn_notice = (Button)findViewById(R.id.btn_admin_notice);
        btn_quit = (Button)findViewById(R.id.btn_admin_quit);

        btn_notice.setOnClickListener(this);
        btn_userInfo.setOnClickListener(this);
        btn_class1.setOnClickListener(this);
        btn_class2.setOnClickListener(this);
        btn_quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;
        switch (v.getId()) {
            case R.id.btn_admin_userinfo:{
                i = new Intent(this, ShowUserInfoActivity.class);
                break;
            }
            case R.id.btn_admin_notice:{
                i = new Intent(this, EditNoticeActivity.class);
                break;
            }
            case R.id.btn_admin_quit:{
                i = new Intent(this, MainActivity.class);
                break;
            }
        }
        startActivity(i);
    }
}