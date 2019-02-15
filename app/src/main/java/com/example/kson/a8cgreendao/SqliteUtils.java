package com.example.kson.a8cgreendao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteUtils extends SQLiteOpenHelper {

    public SqliteUtils( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SqliteUtils( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version,  DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public SqliteUtils( Context context,  String name, int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
