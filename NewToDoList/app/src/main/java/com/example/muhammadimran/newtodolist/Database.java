package com.example.muhammadimran.newtodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad imran on 4/5/2016.
 */
public class Database extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "TODO_LIST";
    private static final String COL_ID = "ID";
    private static final String COL_TITLE = "title";
    private static final String COL_MSG = "message";
    private static final String COL_CHECKBOX = "CHECKBOX";
    public Database(Context context) {
        super(context, "todolistdatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = String.format("create table %s (%s INTEGER primary key AUTOINCREMENT,%s TEXT not null, %s TEXT , %s TEXT )", TABLE_NAME, COL_ID, COL_TITLE, COL_MSG, COL_CHECKBOX);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
    public void savevalues(Message message) {
        SQLiteDatabase sdb = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_TITLE, message.getTitle());
        values.put(COL_MSG, message.getMail());
        values.put(COL_CHECKBOX, message.isRead());
        Log.d("TAG", "Message and title is" + message.getTitle() + " : " + message.getMail());

        sdb.insert(TABLE_NAME, null, values);
        sdb.close();


    }

    public List<Message> getPoints() {
        List<Message> messages = new ArrayList<Message>();
        SQLiteDatabase sqldb = getReadableDatabase();
        String sql = String.format("select %s,%s,%s,%s from %s order by %s", COL_ID, COL_TITLE, COL_MSG, COL_CHECKBOX, TABLE_NAME, COL_ID);
        Cursor cursor = sqldb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String mails = cursor.getString(2);
            String checkbox = cursor.getString(3);


            messages.add(new Message(id, title,mails, Boolean.valueOf(checkbox)));
        }
        sqldb.close();
        return messages;
    }
    public  void delete(int pos){
        getWritableDatabase().delete(TABLE_NAME,COL_ID +"="+pos , null);

    }
}
