package com.androiddevclass.thirstbuster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shawn on 11/27/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "waterTotals.db";
    public static final String TABLE_TOTALS = "waterTotals";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_OUNCESTOTAL = "_ouncestotal";
    public static final String COLUMN_CUPSTOTAL = "_cupstotal";
    public static final String COLUMN_DATE = "_date";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //Creates a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TOTALS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                 COLUMN_OUNCESTOTAL + " INTEGER," +
                COLUMN_CUPSTOTAL + " INTEGER," +
                COLUMN_DATE + " DATE" +
                ");";
        db.execSQL(query);
    }

    //Upgrades the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_TOTALS);
        onCreate(db);
    }

    //Adds new row to database
    public void addTotal(WaterTotals total){
        ContentValues values = new ContentValues();
        values.put( COLUMN_OUNCESTOTAL, total.get_ouncesTotal());
        values.put( COLUMN_CUPSTOTAL, total.get_cupsTotal());
        values.put(COLUMN_DATE, new SimpleDateFormat("yyy-MM-dd").format(new Date()));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TOTALS, null, values);
        db.close();
    }

    public WaterTotals getLatestRecord(){
        WaterTotals latestRecord = new WaterTotals();
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery= "SELECT * FROM " + TABLE_TOTALS +" ORDER BY " + COLUMN_ID + " DESC LIMIT 1";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            latestRecord.set_ouncesTotal(cursor.getString(cursor.getColumnIndex(COLUMN_OUNCESTOTAL)));
            latestRecord.set_cupsTotal(cursor.getString(cursor.getColumnIndex(COLUMN_CUPSTOTAL)));
            latestRecord.set_date(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
            latestRecord.set_id(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
        }
        cursor.close();

        return latestRecord;
    }
}
