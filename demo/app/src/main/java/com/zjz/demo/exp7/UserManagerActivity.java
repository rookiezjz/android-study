package com.zjz.demo.exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.zjz.demo.R;

import java.util.ArrayList;
import java.util.List;

public class UserManagerActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_add,btn_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermanager_layout);
        btn_add = (Button)findViewById(R.id.add);
        btn_list = (Button)findViewById(R.id.list);
        btn_add.setOnClickListener(this);
        btn_list.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v==btn_add) {
            intent = new Intent(UserManagerActivity.this,UserAddActivity.class);
            startActivity(intent);
        }else if(v==btn_list) {
            intent = new Intent(UserManagerActivity.this,UserListActivity.class);
            startActivity(intent);
        }
    }


}