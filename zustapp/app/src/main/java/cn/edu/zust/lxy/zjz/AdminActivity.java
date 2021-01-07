package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class AdminActivity extends AppCompatActivity {
    private List<User> userList = new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);
        initUsers(); //初始化用户数据
        UserAdapter adapter = new UserAdapter(this, R.layout.user_item,
                userList);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }

    private void initUsers() {
        dbHelper = new MyDatabaseHelper(this, "User.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cur = db.rawQuery("select * from UserInfo", null);
        String sType=null, sUsername=null, sPassword=null;
        if(cur.moveToFirst()) {
            sType = cur.getString(3);
            sUsername = cur.getString(1);
            sPassword = cur.getString(2);
            User u = new User(sUsername, sPassword, sType);
            userList.add(u);
        }
        while(cur.moveToNext()) {
            sType = cur.getString(3);
            sUsername = cur.getString(1);
            sPassword = cur.getString(2);
            User u = new User(sUsername, sPassword, sType);
            userList.add(u);
        }
//        Toast.makeText(this, cur.getString(1), Toast.LENGTH_SHORT).show();
        cur.close();
    }
}