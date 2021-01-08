package cn.edu.zust.lxy.zhangjiazheng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.zust.lxy.zhangjiazheng.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_type, et_username, et_password;
    private CheckBox cb_remember;
    private Button btn_login;
    private TextView tv_register;
    private SharedPreferences sp;
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        et_type = (EditText)findViewById(R.id.et_main_type);
        et_username = (EditText)findViewById(R.id.et_main_username);
        et_password = (EditText)findViewById(R.id.et_main_password);
        cb_remember = (CheckBox)findViewById(R.id.cb_main_remember);
        btn_login = (Button)findViewById(R.id.btn_main_login);
        tv_register = (TextView)findViewById(R.id.tv_main_register);

        cb_remember.setOnClickListener(this);
        et_type.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);

        // 记住密码
        sp = getSharedPreferences("sp_data",MODE_PRIVATE);
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
            //登录
            case R.id.btn_main_login:{
                String type = et_type.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (cb_remember.isChecked()) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sp_type", type);
                    editor.putString("sp_username", username);
                    editor.putString("sp_userpassword", password);
                    editor.putBoolean("sp_isRemember", true);
                    editor.commit();
                }
                // 检查账号密码
                if(!type.isEmpty() && !username.isEmpty() && !password.isEmpty() && checkPassword(type, username, password)) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sp_now_name", username);
                    editor.commit();
                    Intent i;
                    if(et_type.getText().toString().equals("管理员"))
                        i = new Intent(this, AdminActivity.class);
                    else if(et_type.getText().toString().equals("信息与计算科学181"))
                        i = new Intent(this, Class1Activity.class);
                    else
                        i = new Intent(this, Class2Activity.class);
                    startActivity(i);
                }else
                    Toast.makeText(this, "用户类型、账号或密码错误！",Toast.LENGTH_SHORT).show();
                break;
            }
            // 选择用户类型
            case R.id.et_main_type:{
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
            // 记住密码
            case R.id.cb_main_remember:{
                if (cb_remember.isChecked()) {
                    Toast.makeText(this,"记住密码！",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this,"取消记住密码！",Toast.LENGTH_SHORT).show();
                break;
            }
            //用户注册
            case R.id.tv_main_register:{
                Intent i = new Intent(this, RegisterActivity.class);
                startActivity(i);
                break;
            }
        }
    }

    public boolean checkPassword(String type, String username, String password) {
        dbHelper = new MyDatabaseHelper(this, "Data.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cur = db.rawQuery("select * from UserInfo where username = \""+et_username.getText().toString()+"\"", null);
        if(cur.getCount()==0)
            return false;
        String sType=null, sUsername=null, sPassword=null;
        cur.moveToFirst();
        sType = cur.getString(3);
        sUsername = cur.getString(1);
        sPassword = cur.getString(2);
//        Toast.makeText(this, cur.getString(1), Toast.LENGTH_SHORT).show();
        cur.close();
        if(type.equals(sType)
                && username.equals(sUsername)
                && password.equals(sPassword))
                return true;
        return false;
    }
}