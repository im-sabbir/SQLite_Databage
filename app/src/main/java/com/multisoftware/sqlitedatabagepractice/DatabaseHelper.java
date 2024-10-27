package com.multisoftware.sqlitedatabagepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "my_database", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table my_table (id INTEGER primary key autoincrement, name TEXT, mobile TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists my_table");
    }


    public void insertdata(String name, String mobile){


        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues conval = new ContentValues();
        conval.put("name", name);
        conval.put("mobile", mobile);

        database.insert("my_table", null, conval);
    }



    public Cursor getalldata(){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table",null);
        return cursor;
    }

    public Cursor searchdatabyid(int id){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table where id like '"+id+"'",null);
        return cursor;
    }

    public Cursor searchdatabyname(String name){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from my_table where name like '%"+name+"%'",null);
        return cursor;
    }


}
