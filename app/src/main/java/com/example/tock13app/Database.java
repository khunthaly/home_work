package com.example.tock13app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DatabaseName = "Db_info.db"; // database name
    public static final String TableName ="tb_Personal";   // table name
    // corum name
    public static final String col_1 ="id";
    public static final String col_2 ="name";
    public static final String col_3 ="surname";
    public static final String col_4 ="phone";
    public static final String col_5 ="email";

    public Database(Context context) {
        super(context, DatabaseName, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TableName+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT,surname TEXT,phone TEXT,email TEXT )");

    }
    public boolean insert(String name,String surname,String phone,String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,name);
        contentValues.put(col_3,surname);
        contentValues.put(col_4,phone);
        contentValues.put(col_5,email);



        long result = sqLiteDatabase.insert(TableName,null,contentValues);
        if (result == -1){
            return false;
        }
        return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TableName);
        onCreate(sqLiteDatabase);
    }
    public static boolean updateData(String name, String surname, String phone, String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_3,surname);
        contentValues.put(col_4,phone);
        contentValues.put(col_5,email);
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tb_Personal where name =?", new String[]{name});

        if (cursor.getCount()>0) {
            long result = sqLiteDatabase.update(TableName, contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public boolean deleteData(String name){//int id-- select * from tb_personal where id?,new String []{Integer.ToString(id)}
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from  tb_Personal where name =?",new String[]{name});

        if (cursor.getCount()>0) {
            long result = sqLiteDatabase.delete(TableName, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public boolean selateData(String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from  tb_Personal where name =?", null);

        if (cursor.getCount()>0) {
            long result = sqLiteDatabase.delete(TableName, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("Select * from tb tb_Personal where name =?", null);
        return cursor;
    }
}
