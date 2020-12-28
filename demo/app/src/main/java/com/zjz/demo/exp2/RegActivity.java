package com.zjz.demo.exp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.EditText;

import com.zjz.demo.R;

import java.util.Calendar;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_city, et_birth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_layout);

        et_city = (EditText)findViewById(R.id.et_reg_city);
        et_city.setOnClickListener(this);

        et_birth = (EditText)findViewById(R.id.et_reg_birth);
        et_birth.setOnClickListener(this);

        Button btn_submmit = (Button)findViewById(R.id.btn_submmit);
        btn_submmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_reg_city:{
                final String[] items={"杭州","北京","上海","广州","深圳"};
                AlertDialog dlg=new AlertDialog.Builder(this)
                        .setTitle("选择城市")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 TODO Auto-generated method stub
                                  et_city.setText(items[which]);
                            }
                        })
                        .show();
                break;
            }
            case R.id.et_reg_birth:{
                OnDateSetListener listener = new OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        et_birth.setText(Integer.toString(year)+"-"+Integer.toString(++month)+"-"+Integer.toString(day));   //将选择的日期显示到TextView中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1
                    }
                };
                Calendar cal= Calendar.getInstance();
                DatePickerDialog dialog=new DatePickerDialog(RegActivity.this,0,listener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH));//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
                dialog.show();
                break;
            }
            case R.id.btn_submmit:{
                final AlertDialog dlg = new AlertDialog.Builder(this)
                        .setTitle("恭喜")
                        .setMessage("注册成功！！！！")
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .show();
                break;
            }
        }
    }
}