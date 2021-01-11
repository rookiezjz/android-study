package cn.edu.zust.lxy.zhangjiazheng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTableActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_class, et_day, et_number, et_lesson;
    private Button btn_submit, btn_back;
    String sp_class=null, sp_day=null, sp_number=null;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittable_layout);
        sp = getSharedPreferences("sp_data",MODE_PRIVATE);
        et_class = (EditText)findViewById(R.id.et_edittable_class);
        et_day = (EditText)findViewById(R.id.et_edittable_day);
        et_number = (EditText)findViewById(R.id.et_edittable_number);
        et_lesson = (EditText)findViewById(R.id.et_edittable_lesson);
        btn_submit = (Button)findViewById(R.id.btn_edittable_submit);
        btn_back = (Button)findViewById(R.id.btn_edittable_back);


        et_class.setOnClickListener(this);
        et_day.setOnClickListener(this);
        et_number.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_edittable_class:{
                final String[] items={"信息与计算科学181","信息与计算科学182"};
                AlertDialog dlg=new AlertDialog.Builder(this)
                        .setTitle("选择班级")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 TODO Auto-generated method stub
                                et_class.setText(items[which]);
                                sp_class = Integer.toString(which+1);
                            }
                        })
                        .show();
                break;
            }
            case R.id.et_edittable_day:{
                final String[] items={"星期一","星期二","星期三","星期四","星期五"};
                AlertDialog dlg=new AlertDialog.Builder(this)
                        .setTitle("选择周几")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 TODO Auto-generated method stub
                                et_day.setText(items[which]);
                                sp_day = Integer.toString(which+1);
                            }
                        })
                        .show();
                break;
            }
            case R.id.et_edittable_number:{
                final String[] items={"1、2节","3、4节","5、6节","7、8节"};
                AlertDialog dlg=new AlertDialog.Builder(this)
                        .setTitle("选择第几节课")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                 TODO Auto-generated method stub
                                et_number.setText(items[which]);
                                sp_number = Integer.toString(which+1);
                            }
                        })
                        .show();
                break;
            }
            case R.id.btn_edittable_submit:{
                String clas = et_class.getText().toString();
                String day = et_day.getText().toString();
                String number = et_number.getText().toString();
                String lesson = et_lesson.getText().toString();
                if(clas.equals("") || number.equals("") || day.equals("") || lesson.equals(""))
                    Toast.makeText(this, "请将表项填写完整",Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(this, "修改成功",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("class"+sp_class+sp_day+sp_number, lesson);
                    editor.commit();
                    et_class.setText("");
                    et_day.setText("");
                    et_number.setText("");
                    et_lesson.setText("");
                }
                break;
            }
            case R.id.btn_edittable_back:{
                Intent i = new Intent(this, AdminActivity.class);
                startActivity(i);
            }
        }
    }
}