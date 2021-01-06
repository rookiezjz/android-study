package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_type, et_username, et_password;
    private CheckBox cb_remember;
    private Button btn_login;
    private TextView tv_register;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        et_type = (EditText)findViewById(R.id.et_home_type);
        et_username = (EditText)findViewById(R.id.et_home_username);
        et_password = (EditText)findViewById(R.id.et_home_password);
        cb_remember = (CheckBox)findViewById(R.id.cb_home_remember);
        btn_login = (Button)findViewById(R.id.btn_home_login);
        tv_register = (TextView)findViewById(R.id.tv_home_register);

        et_type.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);

        // 记住密码
        sp = getSharedPreferences("login",MODE_PRIVATE);
        boolean isRemember = sp.getBoolean("sp_isRemember",false);
        if(isRemember){
            String type = sp.getString("sp_type","");
            String username = sp.getString("sp_username","");
            String userpassword = sp.getString("sp_userpassword","");
            et_type.setText(type);
            et_username.setText(username);
            et_password.setText(userpassword);
            cb_remember.setChecked(true);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home_login:{
                if (cb_remember.isChecked()) {
                    String type = et_type.getText().toString();
                    String username = et_username.getText().toString();
                    String userpassword = et_password.getText().toString();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sp_type", type);
                    editor.putString("sp_username", username);
                    editor.putString("sp_userpassword", userpassword);
                    editor.putBoolean("sp_isRemember", true);
                    editor.commit();
                }
                break;
            }
            case R.id.et_home_type:{
                final String[] items={"管理员","信息与计算科学181","信息与计算科学182"};
                AlertDialog dlg=new AlertDialog.Builder(this)
                        .setTitle("选择用户类型")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 TODO Auto-generated method stub
                                et_type.setText(items[which]);
                            }
                        })
                        .show();
                break;
            }
        }
    }
}