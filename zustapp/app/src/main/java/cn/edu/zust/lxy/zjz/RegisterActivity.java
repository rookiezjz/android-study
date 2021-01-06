package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_type, et_username, et_password;
    private Button bt_reg;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        et_type = (EditText)findViewById(R.id.et_reg_type);
        et_username = (EditText)findViewById(R.id.et_reg_username);
        et_password = (EditText)findViewById(R.id.et_reg_password);
        bt_reg = (Button)findViewById(R.id.bt_reg_reg);

        bt_reg.setOnClickListener(this);
        et_type.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_reg_reg) {
            String type, username, password;
            type = et_type.getText().toString();
            username=et_username.getText().toString();
            password=et_password.getText().toString();
            if(type.equals(""))
                Toast.makeText(this, "请选择用户类型",Toast.LENGTH_SHORT).show();
            else if(username.equals(""))
                Toast.makeText(this, "请填入用户名",Toast.LENGTH_SHORT).show();
            else if(password.equals(""))
                Toast.makeText(this, "请填入密码",Toast.LENGTH_SHORT).show();
            else {
                dbHelper = new MyDatabaseHelper(this, "User.db", null, 1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //组装数据
                values.put("username", username);
                values.put("password", password);
                values.put("type", type);
                db.insert("UserInfo", null, values); //插入数据
                values.clear();
                Toast.makeText(this, "注册成功",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }else if(v.getId() == R.id.et_reg_type) {
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
        }
    }
}