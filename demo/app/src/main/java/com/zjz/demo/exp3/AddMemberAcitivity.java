package com.zjz.demo.exp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zjz.demo.R;
import com.zjz.demo.exp2.SignActivity;

public class AddMemberAcitivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_name, et_number, et_address;
    TextView btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmember_layout);
        et_name = (EditText)findViewById(R.id.et_add_name);
        et_number = (EditText)findViewById(R.id.et_add_number);
        et_address = (EditText)findViewById(R.id.et_add_address);
        btn_submit = (TextView)findViewById(R.id.btn_add_submit);

        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_submit:{
                String sMemberName = et_name.getText().toString(),
                        sMemberNumber = et_number.getText().toString(),
                        sMemberAddress = et_address.getText().toString();
                if (sMemberName.isEmpty())
                    Toast.makeText(this,"请输入姓名！",Toast.LENGTH_LONG).show();
                else if (sMemberNumber.isEmpty())
                    Toast.makeText(this,"请输入电话！",Toast.LENGTH_LONG).show();
                else if (sMemberAddress.isEmpty())
                    Toast.makeText(this,"请输入地址！",Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent(this, ShowMembersActivity.class);
                    intent.putExtra("MemberName", sMemberName);
                    intent.putExtra("MemberNumber", sMemberNumber);
                    intent.putExtra("MemberAddress", sMemberAddress);
                    startActivity(intent);
                }
                break;
            }
        }
    }
}