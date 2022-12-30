package com.example.velidation.activitys;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.velidation.adapters.view_detail_adapter;

public class MyClass extends SQLiteOpenHelper
{
    public MyClass(@Nullable Context context) {
        super(context, "register", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q= "create table student (id integer primary key,name text,contact text,password text)";
        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    void insertdata(String name,String contact,String pass)
    {
        String q="insert into student values(null,'"+name+"','"+contact+"','"+pass+"')";
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL(q);
    }

    public void datadelete(String id)
    {
        String q="delete from student where id='"+id+"'";
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL(q);
    }

    public void dataupdate(String id1,String name1,String contact1,String pass1) {
        String q="update student set name='"+name1+"',contact='"+contact1+"',password='"+pass1+"' where id='"+id1+"'";
        System.out.println(q);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL(q);
    }

    Cursor  getdata()
    {
        String q="select * from student";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery(q,null);
        return c;
    }
}
