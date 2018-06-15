package com.example.urg.rto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by urg on 30/4/17.
 */


    public class DatabaseHelper2 extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "Registration2.db";
        public static final String TABLE_NAME = "register2";
    public static final String COL_1 = "ID";
        public static final String COL_2 = "Vehiclenumber";
        public static final String COL_3 = "Vehiclename";
        public static final String COL_4 = "Vhname";
        public static final String COL_5 = "Vhmobilenumber";
        public static final String COL_6 = "Vhcity";
        public static final String COL_7 = "Licencenumber";
    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }




    @Override
        public void onCreate(SQLiteDatabase db1) {
            db1.execSQL("create table " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Vehiclenumber TEXT ,Vehiclename TEXT,Vhname TEXT,Vhmobilenumber TEXT, Vhcity TEXT, Licencenumber TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
            db1.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db1);
        }

        public boolean insertData(String Vehiclenumber, String Vehiclename, String Vhname, String Vhmobilenumber, String Vhcity, String Licencenumber) {
            SQLiteDatabase db1 = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, Vehiclenumber);
            contentValues.put(COL_3, Vehiclename);
            contentValues.put(COL_4, Vhname);
            contentValues.put(COL_5, Vhmobilenumber);
            contentValues.put(COL_6, Vhcity);
            contentValues.put(COL_7, Licencenumber);
            long result = db1.insert(TABLE_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public Cursor getAllData2() {
            SQLiteDatabase db1 = this.getWritableDatabase();
            Cursor res2 = db1.rawQuery("select * from "+TABLE_NAME,null);
            return res2;
        }

    }
