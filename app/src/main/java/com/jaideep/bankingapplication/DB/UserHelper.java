package com.jaideep.bankingapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jaideep.bankingapplication.DB.UserContract.UserEntry;
import com.jaideep.bankingapplication.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Jaideep Singh', 'jaideep@gmail.com','7869','7278907623', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Aadil Haidar Ali', 'aadil.ha@gmail.com','1852','9008778654', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Mohammad Shoab', 'shoab@gmail.com','8976','7597963350', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Sanskar Kumar Burman', 'sansku@gmail.com','7968','9895632425', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Aasmant Patil', 'aasmant@gmail.com','3869','9095869722', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Dipika Sangwan', 'dipika@gmail.com','9089','8789645328', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Tithi Soni', 'tithi@gmail.com','1279','7896583296', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Neha Bhati', 'nehu@gmail.com','4522','9963978496', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Archana', 'archu@gmail.com','6798','9309689354', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Pratyaksh Srivastava', 'pratyaksht@gmail.com','5099','8296987653', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Anurag Sharma', 'anurag@gmail.com','2776','98765896423', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Abhinav yadav', 'abhinav@gmail.com','1023','9995864259', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Tushita Jain', 'tushita@gmail.com','5886','9865963865', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Aditya kumar', 'aditya@gmail.com','2966','9786352491', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Niraj', 'niraj@gmail.com','6787','6987965634', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}