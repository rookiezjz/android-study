package cn.edu.zust.lxy.zjz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.lxy.zjz.zustapp.R;

public class LeaveWordActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sp;
    private Button btn_submit;
    private EditText et_message;
    private List<Message> messageList = new ArrayList<>();
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_word_layout);

        btn_submit = (Button)findViewById(R.id.btn_submit_leaveword);
        et_message = (EditText)findViewById(R.id.et_leaveword);

        //展示留言板
        initMessage();
        MessageAdapter adapter = new MessageAdapter(this, R.layout.message_item,
                messageList);
        ListView listview = (ListView) findViewById(R.id.list_message);
        listview.setAdapter(adapter);

        //提交留言
        btn_submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==btn_submit) {
            dbHelper = new MyDatabaseHelper(this, "Data.db", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            //组装数据
            sp = getSharedPreferences("sp_data",MODE_PRIVATE);
            String name = sp.getString("sp_now_name","");
            values.put("author", name+"：");
            values.put("msg", et_message.getText().toString());
            db.insert("Message", null, values); //插入数据
            values.clear();
            Toast.makeText(this, "留言成功",Toast.LENGTH_SHORT).show();
            //刷新页面
            finish();
            Intent intent = new Intent(this, LeaveWordActivity.class);
            startActivity(intent);
        }
    }
    private void initMessage() {
        dbHelper = new MyDatabaseHelper(this, "Data.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cur = db.rawQuery("select * from Message", null);
        String sAuthor=null, sContent=null;
        if(cur.moveToLast()) {
            sAuthor = cur.getString(1);
            sContent = cur.getString(2);
            Message u = new Message(sAuthor, sContent);
            messageList.add(u);
        }
        while(cur.moveToPrevious()) {
            sAuthor = cur.getString(1);
            sContent = cur.getString(2);
            Message u = new Message(sAuthor, sContent);
            messageList.add(u);
        }
//        Toast.makeText(this, cur.getString(1), Toast.LENGTH_SHORT).show();
        cur.close();
    }
}