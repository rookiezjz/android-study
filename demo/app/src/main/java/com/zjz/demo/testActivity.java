package com.zjz.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class testActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        //返回主菜单
        Button back_button = (Button)findViewById(R.id.back3_button);
        back_button.setOnClickListener(this);

        // 测试Dialog
        Button test_btn = (Button)findViewById(R.id.test_button);
        test_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back3_button: {
                Intent intent = new Intent(testActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.test_button: {
                final AlertDialog dlg = new AlertDialog.Builder(testActivity.this)
                        .setTitle("警告")
                        .setMessage("确定要删除该信息吗？")
                        .setIcon(R.drawable.sexsi)
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .show();
                break;
            }
        }
    }
}