package com.example.myapplication455;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class    UsersDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    private String[] allColumns = {DatabaseHelper.USER_ID, DatabaseHelper.USER_DATA, DatabaseHelper.USER_PASSWORD, DatabaseHelper.USER_MAIL, DatabaseHelper.USER_PHONE, DatabaseHelper.USER_C, DatabaseHelper.USER_JAVA, DatabaseHelper.USER_PHP};

    public UsersDataSource(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void readdb() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public Userdb createUser(String username, String password, String mail, String phone, int lngc, int lngjava, int lngphp){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.USER_DATA, username);
        values.put(DatabaseHelper.USER_PASSWORD, password);
        values.put(DatabaseHelper.USER_MAIL, mail);
        values.put(DatabaseHelper.USER_PHONE, phone);
        values.put(DatabaseHelper.USER_C, lngc);
        values.put(DatabaseHelper.USER_JAVA, lngjava);
        values.put(DatabaseHelper.USER_PHP, lngphp);

        long insertId = database.insert(DatabaseHelper.TABLE_NAME, null, values);

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,allColumns,DatabaseHelper.USER_ID + " = " + insertId,null,null,null,null);

        cursor.moveToFirst();

        Userdb newUser = cursorToUser(cursor);

        cursor.close();

        return newUser;

    }

    public Boolean checkUserLogin(String username,String password){
        String[] colums = {DatabaseHelper.USER_ID};
        String selection = DatabaseHelper.USER_DATA + "=?" + " and " + DatabaseHelper.USER_PASSWORD + "=?";
        String[] selectionArgs = { username , password };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,colums,selection,selectionArgs,null, null, null);
        int count = cursor.getCount();
        cursor.close();
        if(count > 0){
            return true;
        }
        else {
            return false;
        }

    }

    public void deleteUser(Userdb user){
        long id = user.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.USER_ID + " = " + id, null);
    }

    private Userdb cursorToUser(Cursor cursor){
        Userdb user = new Userdb();
        user.setId(cursor.getLong(0));
        user.setUsername(cursor.getString(1));
        user.setPassword(cursor.getString(2));
        user.setMail(cursor.getString(3));
        user.setPhone(cursor.getString(4));
        user.setlngC(cursor.getInt(5));
        user.setlngJava(cursor.getInt(6));
        user.setlngPhp(cursor.getInt(7));

        return user;

    }
}
