package com.laohu.administrator.yao20.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/28.
 */

public class dbOpenHelper extends SQLiteOpenHelper {
    //static final String DB_NAME="drug_db";
    static final String TB_NAME="drug_tb";
    //SQLiteDatabase DB;
    //String name   "DRUG" 数据库的名字
    //SQLiteDatabase.CursorFactory factory   查询结果的对象 指针
    //int version 数据库存储的版本
   // DB=openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE,null);
   public static final String createTable="CREATE TABLE IF NOT EXISTS "+TB_NAME+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "NAME text,"+
            "CLASSES text,"+
            "EFFECT text,"+
            "FLAVOR_MERIDIAN text,"+
            "SUBCLASS text)";
    private Context mcontext;
    public dbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
        mcontext=context;
    }
    //创建数据库的结构
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
