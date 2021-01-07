package cn.edu.zust.lxy.zjz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CERATE_TABLE = "create table UserInfo ("
            + "id integer primary key AUTOINCREMENT, "
            + "username text, "
            + "password text, "
            + "type text)";
    public static final String ADD_ADMIN = "insert into UserInfo values (1, 'admin', 'admin', '管理员')";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CERATE_TABLE);
        db.execSQL(ADD_ADMIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
}