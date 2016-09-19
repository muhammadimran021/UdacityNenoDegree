package com.example.imran.databaseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imran on 8/29/2016.
 */
public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "dataentry";
    public static final String ID_NAME = "idname";
    public static final String TITLE_NAME = "titlename";
    public static final String DESCRIPTION_NAME = "descriptionname";


    public Database(Context context) {
        super(context, "data.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table %s (%s INTEGER primary key AUTOINCREMENT,%s TEXT not null, %s TEXT )",TABLE_NAME,ID_NAME,TITLE_NAME,DESCRIPTION_NAME);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveData(MyStucture structure){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE_NAME,structure.getTitle());
        values.put(DESCRIPTION_NAME, structure.getDescription());
        // values.put(PERSON_STATUS, arrayList.getCheck());


        db.insert(TABLE_NAME, null, values);


        Log.d("abid", structure.getTitle() + " " + structure.getDescription() + " ");


        db.close();

    }

    public List<MyStucture> getdata() {
       List<MyStucture> stuctures = new ArrayList<MyStucture>();
        SQLiteDatabase data = getReadableDatabase();
        String sql = String.format("select %s,%s,%s from %s order by %s", ID_NAME, TITLE_NAME, DESCRIPTION_NAME, TABLE_NAME, ID_NAME);

        Cursor cursor = data.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String Description = cursor.getString(2);
            //for message print
            Log.d("TAG", "ID is " + id + "title is " + title + "description is " + Description);

            stuctures.add(new MyStucture(title,Description,id));
        }

        data.close();
        return stuctures;


    }

    public void Delete_Item(int pos) {
        this.getWritableDatabase().delete(TABLE_NAME, ID_NAME + "=" + pos, null);
    }

    public void Update_Items(int pos, String dis) {
        ContentValues values = new ContentValues();
        values.put(TITLE_NAME, dis);
        values.put(DESCRIPTION_NAME, dis);

        this.getWritableDatabase().update(TABLE_NAME, values, ID_NAME + "=" + pos, null);
    }
}
