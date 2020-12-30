package com.zjz.demo.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.zjz.demo.R;

public class DataStoreActivity extends AppCompatActivity {
    private EditText usrname, password;
    private TextView login;
    private CheckBox remember;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datastore_layout);

        usrname = findViewById(R.id.et_data_usrname);
        password = findViewById(R.id.et_data_password);
        login = findViewById(R.id.tv_data_login);
        remember = findViewById(R.id.cb_data_remember);

        login.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (remember.isChecked()) {
                         String username = usrname.getText().toString();
                         String userpassword = password.getText().toString();
                         SharedPreferences.Editor editor = sp.edit();
                         editor.putString("sp_username", username);
                         editor.putString("sp_userpassword", userpassword);
                         editor.putBoolean("sp_isRemember", true);
                         editor.commit();
                     }
                 }
             });
        sp = getSharedPreferences("login",MODE_PRIVATE);
        boolean isRemember = sp.getBoolean("sp_isRemember",false);
        if(isRemember){
            String username = sp.getString("sp_username","");
            String userpassword = sp.getString("sp_userpassword","");
            usrname.setText(username);
            password.setText(userpassword);
            remember.setChecked(true);
        }

    }
}