package com.zjz.demo.exp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zjz.demo.HomeActivity;
import com.zjz.demo.R;

public class ShowMembersActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_member_layout);

        Intent intent = getIntent();
        TextView name = (TextView)findViewById(R.id.tv_showname);
        TextView number = (TextView)findViewById(R.id.tv_shownumber);
        TextView address = (TextView)findViewById(R.id.tv_showadd);
        name.setText(intent.getStringExtra("MemberName")==null?"姓名":intent.getStringExtra("MemberName"));
        number.setText("    "+(intent.getStringExtra("MemberNumber")==null?"12345678901":intent.getStringExtra("MemberNumber")));
        address.setText("    "+(intent.getStringExtra("MemberAddress")==null?"杭州小和山":intent.getStringExtra("MemberAddress")));

        TextView addmember = (TextView)findViewById(R.id.btn_addmember);
        addmember.setOnClickListener(this);
        TextView back = (TextView)findViewById(R.id.back3_button);
        back.setOnClickListener(this);
        TextView search = (TextView)findViewById(R.id.btn_show_search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back3_button:{
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_addmember:{
                Intent intent = new Intent(this, AddMemberAcitivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_show_search:{
                EditText et_url = (EditText)findViewById(R.id.et_show_url);
                String url = et_url.getText().toString();
                if(url.equals(""))
                    Toast.makeText(this,"请输入网址！",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri targetUrl = Uri.parse(url);
                    intent.setData(targetUrl);
                    startActivity(intent);
                }
                break;
            }
        }
    }
}