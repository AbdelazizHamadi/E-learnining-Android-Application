package com.example.myapplication455;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="userapp.db";
    public static final String TABLE_NAME ="userd";
    public static final String USER_ID ="ID";
    public static final String USER_DATA ="username";
    public static final String USER_PASSWORD ="password";
    public static final String USER_MAIL ="mail";
    public static final String USER_PHONE ="phone";
    public static final String USER_C ="lnc";
    public static final String USER_JAVA ="lnjava";
    public static final String USER_PHP ="lnphp";

    public static final String DATABASE_CREATE = "create table " + TABLE_NAME + "(" + USER_ID + " integer primary key autoincrement, " + USER_DATA + " text not null, " + USER_PASSWORD + " text not null, " + USER_MAIL + " text not null, " + USER_PHONE + " text not null, " + USER_C + " integer, " + USER_JAVA + " integer, " + USER_PHP + " integer);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*public long addUser(String user, String password, String mail, String phone){
        SQLiteDatabase dtb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("mail", mail);
        contentValues.put("phone", phone);
       /* contentValues.put("lnc", lncc);
        contentValues.put("lnjava", lnjava);
        contentValues.put("lnphp", lnphp);
        long res = dtb.insert("registeruser", null, contentValues);
        dtb.close();
        return res;
    }

    public boolean checkUser(String username, String password){
        String[] colums = { COL_1 };
        SQLiteDatabase dtb = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username , password };
        Cursor cursor = dtb.query(TABLE_NAME,colums,selection,selectionArgs,null, null, null);
        int count = cursor.getCount();
        cursor.close();
        dtb.close();
        if(count > 0){
            return true;
        }
        else {
            return false;
        }
    }
    */
}
