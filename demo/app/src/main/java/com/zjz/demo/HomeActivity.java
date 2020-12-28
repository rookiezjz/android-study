package com.zjz.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zjz.demo.exp2.SignActivity;
import com.zjz.demo.exp3.ShowMembersActivity;

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
        }
    }
}