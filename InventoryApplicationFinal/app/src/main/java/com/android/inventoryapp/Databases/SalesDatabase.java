package com.android.inventoryapp.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.inventoryapp.Models.Products;
import com.android.inventoryapp.Models.Sales_Details;

import java.util.ArrayList;

public class SalesDatabase extends SQLiteOpenHelper {
    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String SALE_QUANTITY = "SALE_QUANTIYT";
    private static final String SALE_PRICE = "SALE_PRICE";
    private static final String SALE_QUANTITYLEFT = "SALE_QUANTITYLEFT";


    public SalesDatabase(Context context) {
        super(context, "salesTable", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT not null,%s INTEGER,%s INTEGER,%s INTEGER)", PRODUCT_TABLE, SALES_ID, PRODUCT_NAME, SALE_QUANTITY, SALE_PRICE, SALE_QUANTITYLEFT);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveSale(Sales_Details sales_details) {
        SQLiteDatabase writableDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(PRODUCT_NAME, sales_details.getProdutName());
        values.put(SALE_QUANTITY, sales_details.getsQuantity());
        values.put(SALE_PRICE, sales_details.getsPrice());
        values.put(SALE_QUANTITYLEFT, sales_details.getsQuantityLeft());

        writableDatabase.insert(PRODUCT_TABLE, null, values);
        Log.d("values ", sales_details.getProdutName() + " " + sales_details.getsQuantity() + " " + sales_details.getsPrice());

        writableDatabase.close();
    }

    public ArrayList<Sales_Details> getSale() {
        ArrayList<Sales_Details> salesArrayList = new ArrayList<>();

        SQLiteDatabase readableDatabase = getReadableDatabase();
        String sql = String.format("select %s,%s,%s,%s,%s from %s order by %s", SALES_ID, PRODUCT_NAME, SALE_QUANTITY, SALE_PRICE, SALE_QUANTITYLEFT, PRODUCT_TABLE, SALES_ID);

        Cursor cursor = readableDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String pName = cursor.getString(1);
            String sQuantity = cursor.getString(2);
            String sPrice = cursor.getString(3);
            String sQuantityLeft = cursor.getString(4);
            Log.d("sales List", "name and msg is " + pName + sQuantity);

            salesArrayList.add(new Sales_Details(pName, Integer.valueOf(sQuantity), Integer.valueOf(sPrice), id, Integer.valueOf(sQuantityLeft)));
            Log.d("Int Sales Values", Integer.valueOf(sQuantity).toString());
        }
        readableDatabase.close();


        return salesArrayList;
    }

    //    public void update(int pos,int quantity){
//        ContentValues values = new ContentValues();
//        values.put(PRODUCT_QUANTITY,String .valueOf(quantity));
//
//        Log.d("tag",PRODUCT_QUANTITY);
//        this.getWritableDatabase().update(PRODUCT_TABLE,values,PRODUCT_ID+"="+pos,null);
//    }
    public void deleteProduct(int pos) {
        this.getWritableDatabase().delete(PRODUCT_TABLE, SALES_ID + "=" + pos, null);
    }
}
