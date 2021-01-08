package cn.edu.zust.lxy.zjz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER_TABLE = "create table UserInfo ("
            + "id integer primary key AUTOINCREMENT, "
            + "username text, "
            + "password text, "
            + "type text)";
    public static final String CREATE_MESSAGE_TABLE = "create table Message ("
            + "id integer primary key AUTOINCREMENT, "
            + "author text, "
            + "msg text)";
    public static final String ADD_ADMIN = "insert into UserInfo values (1, 'admin', 'admin', '管理员')";
    public static final String ADD_MESSAGE = "insert into Message values (1, 'admin:', '欢迎来到ZUSTAPP')";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_MESSAGE_TABLE);
        db.execSQL(ADD_ADMIN);
        db.execSQL(ADD_MESSAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
}
