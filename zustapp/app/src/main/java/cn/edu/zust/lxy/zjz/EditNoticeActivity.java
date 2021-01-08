package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class EditNoticeActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_notice;
    private Button btn_confirm;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editnotice_layout);
        et_notice = (EditText)findViewById(R.id.et_notice);
        btn_confirm = (Button) findViewById(R.id.btn_confirm_notice);
        sp = getSharedPreferences("sp_data",MODE_PRIVATE);

        btn_confirm.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==btn_confirm) {
            if(et_notice.getText().toString().equals("")) {
                Toast.makeText(this, "公告不能为空", Toast.LENGTH_SHORT).show();
            } else {
                String s = et_notice.getText().toString();
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("sp_notice", s);
                editor.commit();
                Intent i = new Intent(this, AdminActivity.class);
                startActivity(i);
            }
        }
    }
}