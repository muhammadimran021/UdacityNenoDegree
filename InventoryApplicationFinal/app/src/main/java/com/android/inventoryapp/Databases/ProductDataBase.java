package com.android.inventoryapp.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.inventoryapp.Models.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductDataBase extends SQLiteOpenHelper {
    private static final String PRODUCT_TABLE = "PRODUCTS";
    private static final String PRODUCT_ID="PRODUCT_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String PRODUCT_QUANTITY = "PRODUCT_QUANTIYT";
    private static final String PRODUCT_PRICE = "PRODUCT_PRICE";


    public ProductDataBase(Context context) {
        super(context, "ProductTable", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT not null,%s INTEGER,%s INTEGER)", PRODUCT_TABLE, PRODUCT_ID, PRODUCT_NAME,PRODUCT_QUANTITY,PRODUCT_PRICE);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveProduct(Products products){
        SQLiteDatabase writableDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(PRODUCT_NAME, products.getProdutName());
        values.put(PRODUCT_QUANTITY, products.getpQuantity());
        values.put(PRODUCT_PRICE, products.getpPrice());

        writableDatabase.insert(PRODUCT_TABLE, null, values);
        Log.d("values ",products.getProdutName()+" "+products.getpQuantity()+" "+products.getpPrice());

        writableDatabase.close();
    }

    public ArrayList<Products> getProduct(){
        ArrayList<Products> productsArrayList = new ArrayList<>();

        SQLiteDatabase readableDatabase = getReadableDatabase();
        String sql = String.format("select %s,%s,%s,%s from %s order by %s", PRODUCT_ID, PRODUCT_NAME, PRODUCT_QUANTITY,PRODUCT_PRICE, PRODUCT_TABLE, PRODUCT_ID);

        Cursor cursor = readableDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String pName = cursor.getString(1);
            String pQuantity = cursor.getString(2);
            String pPrice = cursor.getString(3);
            Log.d("DataBaseList", "name and msg is " + pName + pQuantity);

           productsArrayList.add(new Products(pName,Integer.valueOf(pQuantity),Integer.valueOf(pPrice),id));
           Log.d("Int Values",Integer.valueOf(pQuantity).toString());
        }
        readableDatabase.close();


        return productsArrayList;
    }

    public void update(int pos,int quantity){
        ContentValues values = new ContentValues();
        values.put(PRODUCT_QUANTITY,String .valueOf(quantity));

        Log.d("tag",PRODUCT_QUANTITY);
        this.getWritableDatabase().update(PRODUCT_TABLE,values,PRODUCT_ID+"="+pos,null);
    }

    public void updateOrder(int pos,int quantity){
        ContentValues values = new ContentValues();
        values.put(PRODUCT_QUANTITY,String .valueOf(quantity));

        Log.d("tag",String .valueOf(quantity));
        this.getWritableDatabase().update(PRODUCT_TABLE,values,PRODUCT_ID+"="+pos,null);
    }

    public void deleteProduct(int pos){
        this.getWritableDatabase().delete(PRODUCT_TABLE,PRODUCT_ID+"="+pos,null);
    }
}
