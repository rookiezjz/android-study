package com.zjz.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.zjz.demo.exp2.SignActivity;
import com.zjz.demo.exp3.ShowMembersActivity;
import com.zjz.demo.exp4.ShowPowerActivity;
import com.zjz.demo.exp5.MusicPlayerActivity;
import com.zjz.demo.exp6.DataStoreActivity;
import com.zjz.demo.exp7.UserManagerActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        // 实验2
        Button exp2_button = (Button)findViewById(R.id.exp2_button);
        exp2_button.setOnClickListener(this);

        // 实验3
        Button exp3_button = (Button)findViewById(R.id.exp3_button);
        exp3_button.setOnClickListener(this);

        // 实验4
        Button exp4_button = (Button)findViewById(R.id.exp4_button);
        exp4_button.setOnClickListener(this);

        //实验5
        Button exp5_button = (Button)findViewById(R.id.exp5_btn);
        exp5_button.setOnClickListener(this);

        //实验6
        Button exp6_button = (Button)findViewById(R.id.exp6_btn);
        exp6_button.setOnClickListener(this);

        //实验7
        Button exp7_button = (Button)findViewById(R.id.exp7_btn);
        exp7_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exp2_button:{
                Intent intent = new Intent(HomeActivity.this, SignActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exp3_button:{
                Intent intent = new Intent(HomeActivity.this, ShowMembersActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exp4_button:{
                Intent intent = new Intent(HomeActivity.this, ShowPowerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exp5_btn:{
                Intent intent = new Intent(this, MusicPlayerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exp6_btn:{
                Intent intent = new Intent(this, DataStoreActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.exp7_btn:{
                Intent intent = new Intent(this, UserManagerActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}