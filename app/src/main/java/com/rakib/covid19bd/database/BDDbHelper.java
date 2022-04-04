package com.rakib.covid19bd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.Country;
import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.TABLE_NAME;

public class BDDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = BDDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "Bangladesh.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public BDDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_DEVICE_TABLE =  "CREATE TABLE " + CountriesDbEntries.CountryDbEntry.TABLE_NAME + " ("
                + CountriesDbEntries.CountryDbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Country + " TEXT NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.Date + " TEXT NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.NewConfirmed + " INTEGER NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.NewDeaths + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.NewRecovered + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalConfirmed + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalDeaths + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalRecovered + " INTEGER NOT NULL);";



        // Execute the SQL statement
        db.execSQL(SQL_CREATE_DEVICE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertData(String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Country,name);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }

    }

}
