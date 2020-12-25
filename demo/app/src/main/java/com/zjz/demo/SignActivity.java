package com.zjz.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_layout);
        //返回主菜单
        Button back_button = (Button)findViewById(R.id.back2_button);
        back_button.setOnClickListener(this);

        //登录提示
        Button signin_button = (Button)findViewById(R.id.signin_button);
        signin_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back2_button:{
                Intent intent  = new Intent(SignActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.signin_button:{
                EditText edit_usrname = (EditText)findViewById(R.id.edit_usrname);
                EditText edit_password = (EditText)findViewById(R.id.edit_password);
                String sUsrname = edit_usrname.getText().toString(),
                        sPassword = edit_password.getText().toString();
                if(sUsrname.equals("admin") && sPassword.equals("12345")) {
                    final AlertDialog dlg = new AlertDialog.Builder(SignActivity.this)
                            .setTitle("👈←←👈←←👈←←👈←←")
                            .setMessage("登陆成功！！！！")
                            .setIcon(R.drawable.sexsi)
                            .setPositiveButton("很确定", null)
                            .setNegativeButton("确定", null)
                            .show();
                } else {
                    Toast.makeText(SignActivity.this,"账号是“admin”，密码是“12345”",Toast.LENGTH_LONG).show();
                }
                break;
            }

        }
    }
}