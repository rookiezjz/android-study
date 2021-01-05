package com.zjz.demo.exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.zjz.demo.R;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        init(); // 初始化水果数据
        UserAdapter adapter = new UserAdapter(this, R.layout.user_item, userList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }
    private void init() {
        User u1 = new User("Zjz", "1585108534", "2235325122@qq.com");
        userList.add(u1);
        User u2 = new User("詹姆斯", "123456789", "james@qq.com");
        userList.add(u2);
        User u3 = new User("乔丹", "987654321", "jordan@qq.com");
        userList.add(u3);
    }
}