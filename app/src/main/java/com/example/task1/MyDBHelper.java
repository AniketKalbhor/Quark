package com.example.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "LoginDB";
    public static final String LOGIN_CRED = "login_credentials";
    public static final String KEY_PHONE = "phone";
//    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAME = "name";
    public static final int DB_VERSION = 1;

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE " + LOGIN_CRED +
//                "(" + KEY_NAME + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_PASSWORD + " TEXT, " + KEY_PHONE + " TEXT, " + "PRIMARY KEY " + "(" + KEY_EMAIL + ")" + ")" + ";");
        String CREATE_NEWUSER_TABLE = "CREATE TABLE " + LOGIN_CRED + " ("
                + KEY_NAME + " TEXT, "+ KEY_EMAIL + " TEXT PRIMARY KEY, " + KEY_PASSWORD + " TEXT, " + KEY_PHONE + " TEXT " + ")";
        db.execSQL(CREATE_NEWUSER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LOGIN_CRED);
        onCreate(db);
    }

    public void addCreds(String name, String email, String password, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_PHONE, phone);
        db.insert(LOGIN_CRED,null, values);
    }

    public ArrayList<LoginModel> fetchCred(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ LOGIN_CRED, null);
        ArrayList<LoginModel> arrCred = new ArrayList<>();
        while(cursor.moveToNext()){
            LoginModel model = new LoginModel();
            model.name = cursor.getString(0);
            model.email = cursor.getString(1);
            model.password = cursor.getString(2);
            model.phone = cursor.getString(3);

            arrCred.add(model);
        }
        return arrCred;
    }
}

